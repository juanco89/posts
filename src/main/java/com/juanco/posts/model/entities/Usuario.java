
package com.juanco.posts.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Entity
@Table(name = "usuario", catalog = "posts", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "password")
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario[ nombre=" + nombre + " ]";
    }
    
}
