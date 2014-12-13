
package com.juanco.posts.controller.converter;


import com.juanco.posts.model.entities.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Convertidor para los valores de la entidad Categoria.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
@FacesConverter("CategoriaConverter")
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null ||value.isEmpty()) {
            return null;
        }
        
        System.out.println(value);
        
        return new Categoria(1, value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null)
            return "";
        
        return ((Categoria) value).getDescripcion();
    }
    
}
