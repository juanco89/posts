
package com.juanco.posts.model.dao;

import com.juanco.posts.model.Usuario;
import com.juanco.posts.model.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao para el acceso a los datos de la tabla Usuario.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class DaoUsuarios {
    
    public DaoUsuarios() {
        
    }
    
    /**
     * Busca un usuario en la base de datos.
     * 
     * @param String - Nombre de usuario que identifica al mismo.
     * @return Usuario - Instancia con el usuario encontrado.
     */
    public Usuario buscar(String user) {
        Connection conex = Conexion.getConnection();
        String sql = "select * from usuarios where nombre = ?";
        Usuario dto = null;
        try (PreparedStatement pStat = conex.prepareStatement(sql)) {
            pStat.setString(1, user);
            ResultSet rs = pStat.executeQuery();
            if(rs.next()) {
                dto = new Usuario();
                dto.setNombre(rs.getString("nombre"));
                dto.setSecret(rs.getString("password"));
            }
        } catch (SQLException ex) { 
        }
        return dto;
    }
    
    /**
     * Busca todos los registros de usuarios encontrados en el data source.
     * 
     * @return List<Usuario> - Lista con todos los usuarios encontrados.
     */
    public List<Usuario> buscarTodo() {
        Connection conex = Conexion.getConnection();
        String sql = "select * from usuarios";
        List<Usuario> usuarios = null;
        try (Statement stat = conex.createStatement()) {
            ResultSet rs = stat.executeQuery(sql);
            usuarios = new ArrayList<>();
            while(rs.next()) {
                Usuario dto = new Usuario();
                dto.setNombre(rs.getString("nombre"));
                dto.setSecret(rs.getString("password"));

                usuarios.add(dto);
            }
        } catch (SQLException ex) { 
        }
        return usuarios;
    }
    
}
