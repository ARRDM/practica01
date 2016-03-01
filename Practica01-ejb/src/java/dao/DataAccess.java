/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dao;

import db.DBUtils;
import fciencias.riesgotec.javaee.Capturista;
import fciencias.riesgotec.javaee.Venta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardo_rodab
 */
public class DataAccess {
    
    /**
     * Agrega un capturista a la base de datos.
     * @param cap - Es el capturista a agregar.
     */
    public void agregaCapturista(Capturista cap){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("INSERT INTO capturista"
                    + "(id_capturista,nombre_capturista,apellido_paterno_capturista,"
                    + "apellido_materno_capturista)"
                    + " VALUES("+cap.getId()+",?,?,?)");
            ps.setString(1, cap.getNombre());
            ps.setString(2, cap.getApellidoPaterno());
            ps.setString(3, cap.getApellidoMaterno());
            ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Agrega una venta a la base de datos y lo relaciona con un capturista.
     * @param cap - Es la venta a agregar y el capturista.
     */
    public void agregaVenta(Capturista cap, Venta vent){
        agregaVentaAux(vent);
        agregaRelacion(cap.getId(), vent.getId());
    }
    
    public int getMaxIdVenta(){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_venta,u.fecha_venta,u.total_venta"
                    + " FROM venta AS u WHERE u.id_venta = "
                    +"(SELECT MAX(d.id_venta)"
                    + " FROM venta AS d)");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt(1);           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int getMaxIdCapturista(){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_capturista,u.nombre_capturista,u.apellido_paterno_ca"
                    + "pturista,u.apellido_materno_capturista"
                    + " FROM Capturista AS u WHERE u.id_capturista = "
                    +"(SELECT MAX(d.id_capturista)"
                    + " FROM capturista AS d)");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getInt(1);           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
        public Capturista getCapturista(int id){
        Capturista cap = new Capturista();
         try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_capturista,u.nombre_capturista,u.apellido_paterno_ca"
                    + "pturista,u.apellido_materno_capturista"
                    + " FROM Capturista AS u WHERE u.id_capturista = "+id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cap = new Capturista(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4));                
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return cap;
    }
    
    public Venta getVenta(int id){
        Venta vent = new Venta();
         try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_venta,u.fecha_venta,u.total_venta"
                    + " FROM venta AS u WHERE u.id_venta = "+id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Date fecha = rs.getDate(2); 
                int anio,mes,dia;
                anio = Integer.parseInt(fecha.toString().split("-")[0]);
                mes = Integer.parseInt(fecha.toString().split("-")[1]);
                dia = Integer.parseInt(fecha.toString().split("-")[2]);
                vent = new Venta(id, anio,mes,dia,rs.getInt(3));                
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return vent;
    }
    
    //Metodo privado que agrega una relación venta-capturista a la base de datos.
    private void agregaRelacion(int cap, int vent){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("INSERT INTO venta_capturista"
                    + "(id_venta,id_capturista)"
                    + " VALUES("+vent+","+cap+")");
            ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo privado que agrega una venta a la base de datos.
    private void agregaVentaAux(Venta vent){
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("INSERT INTO venta"
                    + "(id_venta,fecha_venta,total_venta)"
                    + " VALUES("+vent.getId()+",'"+vent.getMes()
                    +"/"+vent.getDia()+"/"+vent.getAnio()+"',"+vent.getTotal()+")");
            ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
