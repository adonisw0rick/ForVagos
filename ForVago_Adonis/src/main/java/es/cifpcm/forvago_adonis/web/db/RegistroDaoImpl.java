/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.Registro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 *
 * @author Adonis
 */
public class RegistroDaoImpl implements RegistroDao {
    Connection connect = null;
    
    public void getConnection() {
        ResourceBundle rb = ResourceBundle.getBundle("forvagos");
        String driver = rb.getString("database.driver");
        String url = rb.getString("database.url");
        String user = rb.getString("database.user");
        String password = rb.getString("database.password");
        
        try {
            
            Class.forName(driver);   
            connect = DriverManager.getConnection(url, user, password);               
            
        } catch (SQLException ex) {
             //logger.debug("En la coneccion a la base de datos:" + ex);
        } catch (ClassNotFoundException ex) {        
             //logger.debug("En la coneccion a la base de datos:" + ex);
        }
    }
    public void addUser(String first_name, String last_name, String email, String password) {        
        
        /*getConnection();
        
        try {
            PreparedStatement pstmt = 
                    connect.prepareStatement("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)");
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            int executeUpdate = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            //logger.debug("Obteniendo resultados y guardando en la lista: " + ex);
        }       
        try {   
            connect.close();
        } catch (SQLException ex) {
            //logger.debug("Cerrando conneccion: " + ex);
        }
        */
        String result ="error";
        
        try (Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/forvagos",
                        "2dawa", "2dawa")) {
        String query = "INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)";
        
            try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                //result = "ok";
                pstmt.setString(1, first_name);
                pstmt.setString(2, last_name);
                pstmt.setString(3, email);
                int rs = pstmt.executeUpdate();
                
                        if (rs != 0) { // Hay registro luego login ok
                            result = "actorDetail";
                        } else {
                            result = "error";
                        }
                ResultSet rd = pstmt.getGeneratedKeys();
                
                while (rd.next()) {
                //actor.setId(rd.getInt(1));
                }
                }
                    
                conn.close();
            
        } catch (SQLException ex) {
    }
        
    }

}
