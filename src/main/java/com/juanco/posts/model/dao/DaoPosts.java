
package com.juanco.posts.model.dao;

import com.juanco.posts.model.entities.Post;
import com.juanco.posts.util.Logg;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Stateless
public class DaoPosts {
    
    @PersistenceContext(unitName = "PostsDataSourceUP")
    private EntityManager em;
    
    public DaoPosts() {
    }
    
    public List<Post> buscarTodos() {
        try {
            List<Post> posts = em.createQuery("SELECT p FROM Post p").getResultList();
            return posts;
        }catch(Exception e){
            new Logg().registrar(e.getLocalizedMessage());
        }
        return null;
    }
    
    public boolean insertar(Post post) {
        try {
            em.persist(post);
            return true;
        }catch(Exception e) {
            new Logg().registrar(e.getLocalizedMessage());
            return false;
        }
    }
    
}
