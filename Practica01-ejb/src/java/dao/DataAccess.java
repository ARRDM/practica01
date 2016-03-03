/* -------------------------------------------------------------------
 * DataAccess.java
 * versión 1.0
 * Copyright (C) 2016  ARRDM.
 * Facultad de Ciencias,
 * Universidad Nacional Autónoma de México, Mexico.
 *
 * Este programa es software libre; se puede redistribuir
 * y/o modificar en los términos establecidos por la
 * Licencia Pública General de GNU tal como fue publicada
 * por la Free Software Foundation en la versión 2 o
 * superior.
 *
 * Este programa es distribuido con la esperanza de que
 * resulte de utilidad, pero SIN GARANTÍA ALGUNA; de hecho
 * sin la garantía implícita de COMERCIALIZACIÓN o
 * ADECUACIÓN PARA PROPÓSITOS PARTICULARES. Véase la
 * Licencia Pública General de GNU para mayores detalles.
 *
 * Con este programa se debe haber recibido una copia de la
 * Licencia Pública General de GNU, de no ser así, visite el
 * siguiente URL:
 * http://www.gnu.org/licenses/gpl.html
 * o escriba a la Free Software Foundation Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * -------------------------------------------------------------------
 */
package dao;

import db.DBUtils;
import fciencias.riesgotec.javaee.Capturista;
import fciencias.riesgotec.javaee.Venta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ARRDM
 * @version 1.0
 * @since Mar 03 2016.
 * <p>
 * Clase que da el comportamiento de la base de datos.</p>
 *
 * <p>
 * Desde esta clase podemos obtener el comportamiento deseado de la base de datos.</p>
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
    
    /**
     * Regresa el id maximo de la tabla ventas.
     * @return El id más grandre.
     */
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
    
    /**
     * Metodo para obtener una lista con tooooodos los capturistas.
     * @return La lista de los capturistas.
     */
    public LinkedList<Capturista> getAllCapturista(){
        LinkedList<Capturista> all = new LinkedList<Capturista>();
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_capturista,u.nombre_capturista,u.apellido_paterno_ca"
                    + "pturista,u.apellido_materno_capturista"
                    + " FROM Capturista AS u");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                all.add(new Capturista(rs.getInt(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4)));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    /**
     * Metodo para obtener una lista con tooooodas las ventas.
     * @return La lista de las ventas.
     */
    public LinkedList<Venta> getAllVenta(){
        LinkedList<Venta> all = new LinkedList<Venta>();
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_venta,u.fecha_venta,u.total_venta"
                    + " FROM venta AS u");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Date fecha = rs.getDate(2);
                int anio,mes,dia;
                anio = Integer.parseInt(fecha.toString().split("-")[0]);
                mes = Integer.parseInt(fecha.toString().split("-")[1]);
                dia = Integer.parseInt(fecha.toString().split("-")[2]);
                all.add(new Venta(rs.getInt(1), anio,mes,dia,rs.getInt(3)));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    /**
     * Metodo para obtener el maximo id de la tabla capturista.
     * @return - el id más grande.
     */
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
    
    /**
     * Metodo para obtener un capturista con un id específico.
     * @param id - El id del capturista.
     * @return  El objeto capturista.
     */
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
    
    /**
     * Metodo para obtener una venta con un id específico.
     * @param id - El id de la venta.
     * @return  El objeto vents.
     */
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
    
    /**
     * Obtiene la venta especifica de un día.
     * @param anio - El año de la venta
     * @param mes - El mes de l venta.
     * @param dia - el dia de la venta
     * @return
     */
    public Venta getVenta(int anio, int mes, int dia){
        Venta vent = new Venta();
        try {
            PreparedStatement ps = DBUtils.getPreparedStatement("SELECT "
                    + "u.id_venta,u.fecha_venta,u.total_venta"
                    + " FROM venta AS u WHERE u.fecha_venta <= '"+anio+"-"+mes+"-"+dia+"' AND"
                    + " u.fecha_venta >= '"+anio+"-"+mes+"-"+dia+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Date fecha = rs.getDate(2);
                int id = rs.getInt(1);
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
