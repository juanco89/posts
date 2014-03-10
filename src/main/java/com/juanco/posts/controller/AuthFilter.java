
package com.juanco.posts.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtra las peticiones para asegurar una sesión válida en lugares secretos.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession sesion = req.getSession(false);
        String rUri = req.getRequestURI();
        if(sesion != null && sesion.getAttribute("username") != null) {
            // Tiene session --> no debe ir al index (login)
            if(rUri.indexOf("index.xhtml") >= 0 || rUri.equals(req.getContextPath()) || rUri.equals(req.getContextPath() + "/"))
                res.sendRedirect(req.getContextPath() + "/secure/home.xhtml");
            else 
                chain.doFilter(request, response);
        }else {
            // No tiene session --> sólo se le permite ir a lugares públicos (index)
            if(rUri.indexOf("index.xhtml") >= 0 || rUri.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            }else {
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }
        }
    }

    @Override
    public void destroy() {
        
    }
}
