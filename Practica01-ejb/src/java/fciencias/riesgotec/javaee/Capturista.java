/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fciencias.riesgotec.javaee;

import java.io.IOException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ricardo_rodab
 */
@ApplicationScoped
@Entity
@Table(name="capturista")
public class Capturista {
    
    /** Llave primaria de la tabla capturista. */
    private int id;
    /** Nombre de capturista. */
    private String nombre;
    /** Apellido paterno del  capturista. */
    private String apellidoPaterno;
    /** Apellido materno del capturista. */
    private String apellidoMaterno;

    /**
     * Metodo constructor para un nuevo capturista.
     * @param id - Es el id del capturista.
     * @param nombre - Su nombre.
     * @param apellidoPaterno - Su apellido paterno.
     * @param apellidoMaterno - Su apellido materno.
     */
    public Capturista(int id, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

        /**
     * Metodo constructor sin apellido materno para un nuevo capturista.
     * @param id - Es el id del capturista.
     * @param nombre - Su nombre.
     * @param apellidoPaterno - Su apellido paterno.
     */
    public Capturista(int id, String nombre, String apellidoPaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo constructor que se ofrece por completud.
     */
    public Capturista(){}
    
    
    
    /**
     * Obtiene el id del capturista.
     * @return El id del objeto.
     */
    @Id
    public int getId() {
        return id;
    }
    
    /**
     * Sustituye el id por uno nuevo.
     * @param id - El nuevo id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del capturista.
     * @return El nombre del capturista.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Cambia el nombre del capturista.
     * @param nombre - Es el nuevo nombre del capturista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Nos da el apellido parteno del capturista.
     * @return El apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Nos da el apellido materno si tiene, de lo contrario regresa la cadena
     * vacía.
     * @return El apellido materno o "". 
     */
    public String getApellidoMaterno() {
        if(apellidoMaterno == null)
            return "";
        return apellidoMaterno;
    }

    /**
     * Asigna un nuevo apellido paterno al capturista.
     * @param apellidoPaterno - Es el nuevo apellido.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Asigna un nuevo apellido materno al capturista.
     * @param apellidoMaterno - Es el nuevo apellido.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }  
} //Fin de Capturista.java
