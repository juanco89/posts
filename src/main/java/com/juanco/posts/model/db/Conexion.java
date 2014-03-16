
package com.juanco.posts.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de crear la conexión a la base de datos.
 * 
 * @author Juan C Orozco <juanco89@gmail.com>
 */
public class Conexion {
    
    private final static String DBPATH = "/tmp/posts.db";
    
    private static Connection _mConex;
    
    static public Connection getConnection()
    {
        try {
            if(_mConex == null || _mConex.isClosed()) {
                crearConexionSQlite();
            }
        }catch(SQLException sqle) { }
        return _mConex;
    }
    
    private static void crearConexionSQlite()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            _mConex = DriverManager.getConnection("jdbc:sqlite:" + DBPATH);
        } catch (SQLException | ClassNotFoundException ex) { }
    }
    
}
