/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.Provincia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Adonis
 */
public class ProvinciasDaoImpl implements ProvinciasDao{
    Connection connect = null;      
    
    public void getConnection() {
        //ResourceBundle rb = ResourceBundle.getBundle("sakila");
        ResourceBundle rb = ResourceBundle.getBundle("forvagos");
        String driver = rb.getString("database.driver");
        //String driver = "com.mysql.jdbc.Driver";
        String url = rb.getString("database.url");
        //String url = "jdbc:mysql://localhost:3306/forvagos";
        String user = rb.getString("database.user");
        //String user = "2daw";
        String password = rb.getString("database.password");
        //String password = "2daw";        
        
        try {
            
            Class.forName(driver);   
            connect = DriverManager.getConnection(url, user, password);               
            
        } catch (SQLException ex) {
             //logger.debug("En la coneccion a la base de datos:" + ex);
        } catch (ClassNotFoundException ex) {        
             //logger.debug("En la coneccion a la base de datos:" + ex);
        }
    }
    
    public List<Provincia> selectAll() {        
        
        getConnection();
        
        List<Provincia> provincias = new ArrayList<Provincia>();        
        
        try {
            PreparedStatement pstmt = connect.prepareStatement("select * from provincias");
            
            ResultSet rs = pstmt.executeQuery();
        
            while (rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setId_provincia(rs.getInt(1));
                provincia.setNombre(rs.getString(2));
                provincias.add(provincia);
            }
            
            rs.close();
            pstmt.close();
            
        } catch (SQLException ex) {
            //logger.debug("Obteniendo resultados y guardando en la lista: " + ex);
        }       
        
        try {   
            connect.close();
        } catch (SQLException ex) {
            //logger.debug("Cerrando conneccion: " + ex);
        }
        
        return provincias;
    }

}
