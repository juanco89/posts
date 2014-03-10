
package com.juanco.posts.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class Util {
   
    public static HttpSession getSession() {
    return (HttpSession)
      FacesContext.
      getCurrentInstance().
      getExternalContext().
      getSession(false);
  }
}
