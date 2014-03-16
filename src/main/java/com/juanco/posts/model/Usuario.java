
package com.juanco.posts.model;

import java.io.Serializable;

/**
 * Clase del modelo que representa aun usuario del sistema.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Usuario implements Serializable {
   
    private String nombre;
    private String secret;
    
    public Usuario() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
