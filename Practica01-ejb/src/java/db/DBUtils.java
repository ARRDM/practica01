/* -------------------------------------------------------------------
 * DBUtils.java
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
package db;

import java.sql.PreparedStatement;

/**
 * @author ARRDM
 * @version 1.0
 * @since Mar 03 2016.
 * <p>
 * Clase que podaemos hacer parte del CRUD.</p>
 *
 * <p>
 * Desde esta clase podemos obtener el comportamiento CRUD.</p>
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
        String password = "*contraseña*";
        Connection conexion = DriverManager.getConnection(url,user,password);
        ps = conexion.prepareStatement(sql);
        return ps;
    }
    
}
