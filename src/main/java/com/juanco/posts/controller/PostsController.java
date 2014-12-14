
package com.juanco.posts.controller;

import com.juanco.posts.model.dao.DaoPosts;
import com.juanco.posts.model.entities.Post;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Named
@RequestScoped
public class PostsController implements Serializable {

    private List<Post> posts;
    
    @EJB( name = "DaoPosts" )
    private DaoPosts dao;
    
    public PostsController() {
    }
    
    @PostConstruct
    public void buscarListaDatos() {
        posts = dao.buscarTodos();
    }
    
    
    /*** operaciones de negocio ***/
    
    public String prepararNuevoPost() {
        return "nueva-publicacion";
    }
    
    
    /*** accesores ***/
    
    public List<Post> getPosts() {
        return posts;
    }
}
