
package com.juanco.posts.model.dao;

import com.juanco.posts.model.entities.Categoria;
import com.juanco.posts.util.Logg;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Stateless
public class DaoCategorias {

    @PersistenceContext(unitName = "PostsDataSourceUP")
    private EntityManager em;
    
    public DaoCategorias() {
    }
    
    public List<Categoria> buscarTodos() {
        try {
            List<Categoria> categorias = em.createQuery("SELECT c FROM Categoria c").getResultList();
            return categorias;
        }catch(Exception e){
            new Logg().registrar(e.getLocalizedMessage());
        }
        return null;
    }
}
