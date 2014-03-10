
package com.juanco.posts.controller;

import com.juanco.posts.model.Usuario;
import com.juanco.posts.model.dao.DaoUsuarios;
import com.juanco.posts.util.MD5;
import com.juanco.posts.util.Util;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * Controlador para el manejo de session y autenticación.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
// @ManagedBean
@Named  // JEE7
@SessionScoped
public class LoginController implements Serializable {
    
    private final Usuario usuario;

    public LoginController() {
        usuario = new Usuario();
    }

    public String getUsuario() {
        return usuario.getNombre();
    }

    public void setUsuario(String usuario) {
        this.usuario.setNombre(usuario);
    }

    public String getPassword() {
        return usuario.getSecret();
    }

    public void setPassword(String password) {
        this.usuario.setSecret(password);
    }
    
    public String doLogin() {
        
        if(!usuario.getNombre().isEmpty() && !usuario.getSecret().isEmpty()) {
            
            String pass = MD5.toHexString(usuario.getSecret());
            
            DaoUsuarios dao = new DaoUsuarios();
            Usuario storedUser = dao.buscar(usuario.getNombre());
            
            if(storedUser != null && storedUser.getSecret().equals(pass)) {
                HttpSession sesion = Util.getSession();
                sesion.setAttribute("username", usuario.getNombre());
                return "login-success";
            }
            
        }
        // TODO: Set failure messages
        usuario.setSecret("");
        return "login-failed";
    }
    
    public void logout() {
        HttpSession sesion = Util.getSession();
        sesion.invalidate();
        try {
            // return "/home.xhtml?faces-redirect=true";
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
        }catch(IOException e) { }
    }
}
