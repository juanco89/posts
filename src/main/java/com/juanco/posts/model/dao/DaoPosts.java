
package com.juanco.posts.model.dao;

import com.juanco.posts.model.Categoria;
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
        String sql = "select *, p.id as pid, c.id as cid from post p, categoria c where p.categoria = c.id";
        List<Post> lista = new ArrayList<>();
        try (PreparedStatement pStat = conex.prepareStatement(sql)) {
            ResultSet rs = pStat.executeQuery();
            Post dto;
            Categoria categoria;
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("cid"));
                categoria.setNombre(rs.getString("nombre"));
                
                dto = new Post();
                dto.setId(rs.getInt("pid"));
                dto.setTitulo(rs.getString("titulo"));
                dto.setDetalle(rs.getString("detalle"));
                dto.setFecha(new Date(rs.getDate("fecha").getTime()));
                dto.setAutor(rs.getString("autor"));
                dto.setCategoria(categoria);
                
                lista.add(dto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return lista;
    }
}
