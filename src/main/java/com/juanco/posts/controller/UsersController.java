
package com.juanco.posts.controller;

import com.juanco.posts.model.Usuario;
import com.juanco.posts.model.dao.DaoUsuarios;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Clase controladora para la gestión de usuarios.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Named
@RequestScoped
public class UsersController implements Serializable{

    private final List<Usuario> usuarios;
    
    public UsersController() {
        DaoUsuarios dao = new DaoUsuarios();
        usuarios = dao.buscarTodo();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
