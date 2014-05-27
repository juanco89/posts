
package com.juanco.posts.model;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Categoria {

    /** Identificador de la entidad. */
    private int id;
    
    /** Nombre / Descripción de la categoria. */
    private String nombre;
    
    public Categoria() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
