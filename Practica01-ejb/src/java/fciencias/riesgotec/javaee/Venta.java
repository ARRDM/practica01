/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fciencias.riesgotec.javaee;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ricardo_rodab
 */
@ApplicationScoped
@Entity
@Table(name="venta")
public class Venta {
      
    /** Llave primaria de la tabla venta. */
    private int id;
    /** Anio de la venta. */
    private int anio;
    /** Mes de la venta. */
    private int mes;
    /** Dia de la venta. */
    private int dia;
    /** Suma total de la venta. */
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
    public Venta(){}

    /**
     * Regresa el identificador primario del objeto.
     * @return el id del objeto.
     */
    @Id
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
   
}
