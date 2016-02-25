/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fciencias.riesgotec.javaee;

import java.io.IOException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ricardo_rodab
 */
@ApplicationScoped
public class Capturista {
    
    private int contador;
    private String aManipular;
    
    
    public void setContador(int contador) {
        this.contador = contador;
    }

    public void setAManipular(String aManipular) {
        this.aManipular = aManipular;
    }

    public int getContador() {
        return contador;
    }

    public String getAManipular() {
        return aManipular;
    }
    
    
    public void atiende(String cadena)throws IOException{
        this.contador++;
        this.aManipular = cadena.toUpperCase();
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("index.xhtml");
    }
    
}
