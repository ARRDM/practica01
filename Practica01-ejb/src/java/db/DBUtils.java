/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.PreparedStatement;

/**
 *
 * @author ricardo_rodab
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtils {
    
    protected static PreparedStatement ps;
 
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = null;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.0.1:5432/autoservicio";
        String user = "ricardo_rodab";
        String password = "115820012007";
        Connection conexion = DriverManager.getConnection(url,user,password);
        ps = conexion.prepareStatement(sql);
        return ps;
    }
    
}
