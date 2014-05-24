
package com.juanco.posts.controller;

import com.juanco.posts.model.Post;
import com.juanco.posts.model.dao.DaoPosts;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Named
@RequestScoped
public class PostsController {

    private final List<Post> posts;
    
    public PostsController() {
        DaoPosts dao = new DaoPosts();
        posts = dao.buscarTodos();
    }
    
    public List<Post> getPosts() {
        return posts;
    }
}
