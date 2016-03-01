/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dao;

import db.DBUtils;
import fciencias.riesgotec.javaee.Capturista;
import fciencias.riesgotec.javaee.Venta;
import java.sql.PreparedStatement;
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
                    + "(id_venta,fecha_venta,total_venta,"
                    + " VALUES("+vent.getId()+",?,"+vent.getTotal()+")");
            String fecha = vent.getMes()+"/"+vent.getDia()+"/"+vent.getAnio();
            ps.setString(1, fecha);
            ps.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}