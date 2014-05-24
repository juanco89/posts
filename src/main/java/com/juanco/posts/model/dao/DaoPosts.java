
package com.juanco.posts.model.dao;

import com.juanco.posts.model.Post;
import com.juanco.posts.model.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class DaoPosts {
    
    public DaoPosts() { }
    
    public List<Post> buscarTodos() {
        Connection conex = Conexion.getConnection();
        String sql = "select * from post";
        List<Post> lista = new ArrayList<>();
        try (PreparedStatement pStat = conex.prepareStatement(sql)) {
            ResultSet rs = pStat.executeQuery();
            Post dto;
            while (rs.next()) {
                dto = new Post();
                dto.setId(rs.getInt("id"));
                dto.setTitulo(rs.getString("titulo"));
                dto.setDetalle(rs.getString("detalle"));
                dto.setFecha(new Date(rs.getDate("fecha").getTime()));
                
                lista.add(dto);
            }
        } catch (SQLException ex) { }
        return lista;
    }
}
