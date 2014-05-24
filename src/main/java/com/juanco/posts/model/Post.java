
package com.juanco.posts.model;

import java.util.Date;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Post {

    /** Identificador del registro. */
    private int id;
    
    /** Título asignado al Post. */
    private String titulo;
    
    /** Cuerpo del Post. */
    private String detalle;
    
    /** Fecha de publicación. */
    private Date fecha;
    
    public Post() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
