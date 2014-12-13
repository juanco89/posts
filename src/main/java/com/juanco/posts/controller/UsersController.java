
package com.juanco.posts.controller;

import com.juanco.posts.model.dao.DaoUsuarios;
import com.juanco.posts.model.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Clase controladora para la gestión de usuarios.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Named
@RequestScoped
public class UsersController implements Serializable {

    private List<Usuario> usuarios;
    
    @EJB( name = "DaoUsuarios" )
    private DaoUsuarios dao;
    
    public UsersController() {
    }
    
    @PostConstruct
    public void buscarUsuarios() {
        usuarios = dao.buscarTodo();
    }
    
    
    /*** Accesores ***/
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
