
package com.juanco.posts.controller;

import com.juanco.posts.model.dao.DaoUsuarios;
import com.juanco.posts.model.entities.Usuario;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import org.mockito.internal.util.reflection.Whitebox;

/**
 *
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class LoginTest {
    
    private static DaoUsuarios mockedUserDao;
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Creacion del mock
        mockedUserDao = mock(DaoUsuarios.class);
        
        when(mockedUserDao.buscar("juan")).thenReturn(new Usuario("juan", "912ec803b2ce49e4a541068d495ab570"));
        
    }
    
    @Test
    public void findUserInDataSource() {
        System.out.println("Prueba mock");
        
        Usuario usuario = new Usuario("juan", "asdf");
        
        LoginController controller = new LoginController();
        Whitebox.setInternalState(controller, "dao", mockedUserDao);
        boolean logged = controller.identificarUsuarioRegistrado(usuario);
        
        assertTrue(logged);
    }
}
