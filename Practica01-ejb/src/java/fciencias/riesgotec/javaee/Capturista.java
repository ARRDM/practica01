/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fciencias.riesgotec.javaee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author ricardo_rodab
 */
@ApplicationScoped
@Table(name="capturista")
@Entity
/*@NamedQueries({
@NamedQuery(name="Capturista.findAll",
query="SELECT * FROM Capturista;")
})*/
public class Capturista {
    
    @PersistenceContext //(name = "AgregarCapturista")
    public EntityManager em; // = Persistence.createEntityManagerFactory("AgregarCapturista").createEntityManager();
    
    /** Llave primaria de la tabla capturista. */
    @Id
    @Column(name = "id_capturista")
    private int id;
    /** Nombre de capturista. */
    @Column(name = "nombre_capturista")
    private String nombre;
    /** Apellido paterno del  capturista. */
    @Column(name = "apellido_paterno_capturista")
    private String apellidoPaterno;
    /** Apellido materno del capturista. */
    @Column(name = "apellido_materno_capturista")
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
    public Capturista(){
        this.id = -1;
    }
    
    /**
     * Obtiene el id del capturista.
     * @return El id del objeto.
     */
    public int getId() {
        return id;
    }
    
    
    /**
     * Obtiene el nombre del capturista.
     * @return El nombre del capturista.
     */
    public String getNombre() {
        return nombre;
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
     * Sustituye el id por uno nuevo.
     * @param id - El nuevo id.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * Cambia el nombre del capturista.
     * @param nombre - Es el nuevo nombre del capturista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public void agrega()throws IOException{
        //Query agrega = em.createQuery();
        //agrega.executeUpdate();
    }
    
    public String buscaNombre(String nombre){
        Query query = em.createQuery("SELECT u.id,u.nombre,u.apellidoPaterno,u.apellidoMaterno"
                + " FROM Capturista u",Capturista.class);
        //.setMaxResults(10);
        //Query q = em.createNativeQuery("SELECT * FROM capturista",Capturista.class);
        // + " WHERE nombre_capturista LIKE %"+nombre+"%;");
        List<Object[]> rows = query.getResultList();
        List<Capturista> result = new ArrayList<>(rows.size());
        for (Object[] row : rows) {
            result.add(new Capturista((int) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3]));            
        }
            return result.get(0).nombre;
        //return "no";
    }
} //Fin de Capturista.java
