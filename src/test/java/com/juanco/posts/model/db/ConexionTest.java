
package com.juanco.posts.model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;

/**
 *
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class ConexionTest {
    
    public ConexionTest() {
    }

    /**
     * Prueba de creación de la instancia de conexión.
     * Se pide la instancia de conexión y se realiza una consulta
     * a la base de datos.
     */
    @org.junit.Test
    public void testCrearConexionQSLite() {
        System.out.println("crearConexionQSLite");
        
        Connection conex = Conexion.getConnection();
        assertNotNull(conex);
        
        try {
            Statement stat = conex.createStatement();
            assertNotNull(stat);
            
            ResultSet rs = stat.executeQuery("select * from usuarios");
            while(rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) { }
    }
    
}
