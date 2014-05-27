
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
    
    /** Autor del post. */
    private String autor;
    
    /** Género al que pertenece la publicación. */
    private Categoria categoria;
    
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
