
package com.juanco.posts.controller;

import com.juanco.posts.model.dao.DaoCategorias;
import com.juanco.posts.model.dao.DaoPosts;
import com.juanco.posts.model.entities.Categoria;
import com.juanco.posts.model.entities.Post;
import com.juanco.posts.model.entities.Usuario;
import com.juanco.posts.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Named
@SessionScoped
public class PostsController implements Serializable {

    private List<Post> posts;
    private List<SelectItem> itemsCategorias;
    
    private Post post;
    private int categoriaSeleccionada;
    
    @EJB( name = "DaoPosts" )
    private DaoPosts dao;
    
    @EJB( name = "DaoCategorias" )
    private DaoCategorias daoCateg;
    
    public PostsController() {
        categoriaSeleccionada = -1;
    }
    
    @PostConstruct
    public void buscarListaDatos() {
        posts = dao.buscarTodos();
        
        List<Categoria> categorias = daoCateg.buscarTodos();
        
        itemsCategorias = new ArrayList<>();
        for(Categoria c : categorias) {
            itemsCategorias.add(new SelectItem(c.getId(), c.getDescripcion()));
        }
    }
    
    
    /*** operaciones de negocio ***/
    
    public String prepararNuevoPost() {
        post = new Post();
        return "nueva-publicacion";
    }
    
    public String guardarPublicacion() {
        if(categoriaSeleccionada <= 0) {
            // TODO: Mensaje de error.
            return "";
        }
        
        post.setCategoria(new Categoria(categoriaSeleccionada));
        post.setAutor(new Usuario((String)Util.getSession().getAttribute("username")));
        post.setFecha(new Date(System.currentTimeMillis()));
        
        boolean insertado = dao.insertar(post);
        
        if(insertado) {
            posts.add(post);
            categoriaSeleccionada = -1;
            return "posts";
        } else 
            return "nueva-publicacion";
    }
    
    /*** accesores ***/
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public List<SelectItem> getCategorias() {
        return itemsCategorias;
    }
    
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    
    public void setCategoriaSeleccionada(int id) {
        categoriaSeleccionada = id;
    }
    
    public int getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
}
