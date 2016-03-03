/* -------------------------------------------------------------------
 * Venta.java
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
package fciencias.riesgotec.javaee;

import dao.DataAccess;
import java.util.Comparator;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ARRDM
 * @version 1.0
 * @since Mar 03 2016.
 * <p>
 * Clase que podemos tener el comprtamiento de una Venta.</p>
 *
 * <p>
 * Desde esta clase podemos crear objetos de la base de datos tipo Venta.</p>
 */
@ApplicationScoped
@Entity
@Table(name="venta")
public class Venta {

    /** Llave primaria de la tabla venta. */
    @Id
    @Column(name = "id_venta")
    private int id;
    /** Anio de la venta. */
    private int anio;
    /** Mes de la venta. */
    private int mes;
    /** Dia de la venta. */
    private int dia;
    /** Suma total de la venta. */
    @Column(name = "total_venta")
    private double total;
    
    /**
     * Constructor de la clase Venta.
     * @param id - El identificador primario.
     * @param anio - El año de la venta.
     * @param mes´- El mes de la venta.
     * @param dia - El día de la venta.
     * @param total - La suma total de lo que se vendió.
     */
    public Venta(int id, int anio, int mes, int dia, double total) {
        this.id = id;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.total = total;
    }
    
    /**
     * Constructor que se ofrece por completud.
     */
    public Venta(){
        this.id = new DataAccess().getMaxIdVenta()+1;
    }
    
    /**
     * Regresa el identificador primario del objeto.
     * @return el id del objeto.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Nos regresa el año de la venta.
     * @return El año.
     */
    public int getAnio() {
        return anio;
    }
    
    /**
     * Nos regresa el mes de la venta.
     * @return El mes.
     */
    public int getMes() {
        return mes;
    }
    
    /**
     * Nos regresa el día de la venta.
     * @return El día.
     */
    public int getDia() {
        return dia;
    }
    
    /**
     * Nos regresa la suma total de lo que se vendió.
     * @return El total.
     */
    public double getTotal() {
        return total;
    }
    
    /**
     * Asigna un nuevo id al objeto.
     * @param id - El nuevo id.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Asigna un nuevo año al objeto.
     * @param anio El año.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    /**
     * Asigna un nuevo mes al objeto.
     * @param mes - El nuevo mes.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    /**
     * Asigna un nuevo día al objeto.
     * @param dia - El nuevo día.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    /**
     * Asigna el total de venta al objeto.
     * @param total - El total de venta.
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Método para sacar el iva.
     * @return El iva total de esas ventas.
     */
    public double getIva(){
        return this.getTotal()*.16;
    }
    
}
