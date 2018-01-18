/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.hotel.HotelOffer;
import java.math.BigDecimal;
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
public class HotelOfferDaoImpl implements HotelOfferDao{

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
    @Override
    public List<HotelOffer> selectAll() {
        getConnection();
        
        List<HotelOffer> hoteles = new ArrayList<HotelOffer>();        
        
        try {
            PreparedStatement pstmt = connect.prepareStatement("select * from hoteloffer");
            
            ResultSet rs = pstmt.executeQuery();
        
            while (rs.next()) {
                HotelOffer hotel = new HotelOffer();
                hotel.setId_hotel(rs.getInt(1));
                hotel.setHotel(rs.getString(2));
                hotel.setPrice(rs.getBigDecimal(3));
                hotel.setHotelPicture(rs.getString(4));
                hotel.setId_municipio(rs.getInt(5));
                hoteles.add(hotel);
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
        
        return hoteles;
    }

    @Override
    public List<HotelOffer> selectByCriteria(int entero) {
        getConnection();
        
        List<HotelOffer> hoteles = new ArrayList<HotelOffer>();        
        
        try {
            PreparedStatement pstmt = connect.prepareStatement("select * from hoteloffer where id_municipio = ?");
            short id = (short)entero;
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
        
            while (rs.next()) {
                HotelOffer hotel = new HotelOffer();
                hotel.setId_hotel(rs.getInt(1));
                hotel.setHotel(rs.getString(2));
                hotel.setPrice(rs.getBigDecimal(3));
                hotel.setHotelPicture(rs.getString(4));
                hotel.setId_municipio(rs.getInt(5));
                hoteles.add(hotel);
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
        
        return hoteles;
    }

    @Override
    public HotelOffer insert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HotelOffer update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HotelOffer delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
