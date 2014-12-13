
package com.juanco.posts.model.dao;

import com.juanco.posts.model.entities.Usuario;
import com.juanco.posts.util.Logg;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Dao para el acceso a los datos de la tabla Usuario.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@Stateless
public class DaoUsuarios {
    
    @PersistenceContext(unitName = "PostsDataSourceUP")
    private EntityManager em;
    
    public DaoUsuarios() {
    }
    
    /**
     * Busca un usuario en la base de datos.
     * 
     * @param String - Nombre de usuario que identifica al mismo.
     * @return Usuario - Instancia con el usuario encontrado.
     */
    public Usuario buscar(String user) {
        try {
            return em.find(Usuario.class, user);
        }catch(Exception e){
            new Logg().registrar(e.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * Busca todos los registros de usuarios encontrados en el data source.
     * 
     * @return List<Usuario> - Lista con todos los usuarios encontrados.
     */
    public List<Usuario> buscarTodo() {
        try {
            List<Usuario> usuarios = (List<Usuario>) em.createQuery("SELECT u FROM Usuario u").getResultList();
            return usuarios;
        }catch(Exception e){
            new Logg().registrar(e.getLocalizedMessage());
        }
        return null;
    }
    
}
