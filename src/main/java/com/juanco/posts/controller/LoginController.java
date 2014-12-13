
package com.juanco.posts.controller;

import com.juanco.posts.model.dao.DaoUsuarios;
import com.juanco.posts.model.entities.Usuario;
import com.juanco.posts.util.MD5;
import com.juanco.posts.util.Util;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
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
@Named // JEE7
@SessionScoped
public class LoginController implements Serializable {
    
    private final Usuario usuario;
    private boolean logged;
    
    @EJB( name = "DaoUsuarios" )
    private DaoUsuarios dao;
    
    public LoginController() {
        usuario = new Usuario();
        logged = false;
    }
    
    
    /*** operaciones de negocio ***/
    
    public String doLogin() {
        if(identificarUsuarioRegistrado(usuario)) {
            HttpSession sesion = Util.getSession();
            sesion.setAttribute("username", usuario.getNombre());
            logged = true;
            return "login-success";
        }
        // TODO: Set failure messages
        usuario.setPassword("");
        return "login-failed";
    }
    
    public void logout() {
        HttpSession sesion = Util.getSession();
        sesion.invalidate();
        logged = false;
        try {
            // return "/home.xhtml?faces-redirect=true";
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
        }catch(IOException e) { }
    }
    
    
    /*** proceso ***/
    
    /**
     * Verifica si un usuario dado se encuentra registrado en el sistema.
     * 
     * @param user - Usuario - Instancia de usuario a verificar.
     * @return boolean - true si se encuentra en el sistema, false de lo contrario.
     */
    protected boolean identificarUsuarioRegistrado(Usuario user) {
        if(user == null) return false;
        
        if(!user.getNombre().isEmpty() && !user.getPassword().isEmpty()) {
            
            String pass = MD5.toHexString(user.getPassword());
            
            Usuario storedUser = dao.buscar(user.getNombre());
            
            if(storedUser != null && storedUser.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }
    
    
    /*** accesores ***/
    
    public String getUsuario() {
        return usuario.getNombre();
    }

    public void setUsuario(String usuario) {
        this.usuario.setNombre(usuario);
    }

    public String getPassword() {
        return usuario.getPassword();
    }

    public void setPassword(String password) {
        this.usuario.setPassword(password);
    }
    
    public boolean isLogged() {
        return logged;
    }
}
