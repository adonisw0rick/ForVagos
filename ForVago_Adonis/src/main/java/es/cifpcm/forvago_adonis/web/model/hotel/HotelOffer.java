/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model.hotel;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 *
 * @author alumno
 */
public class HotelOffer implements Serializable{
    private int id_hotel;
     private String hotel;
     public BigDecimal price;
     public String hotelPicture;
     private int id_municipio;
     
     public HotelOffer() {
         
     }    
     public HotelOffer(String hotel, BigDecimal price, String hotelPicture) {
         this.hotel = hotel;        
         this.price = price;        
         this.hotelPicture = hotelPicture;    
     }    
     public String getHotel() {        
         return hotel;    
     }    
     public void setHotel(String hotel) {        
         this.hotel = hotel;    
     }    
     public BigDecimal getPrice() {        
         return price;    }    
     public void setPrice(BigDecimal price) {        
         this.price = price;    
     }    
     public String getHotelPicture() {        
         return hotelPicture;    
     }    
     public void setHotelPicture(String hotelPicture) {        
         this.hotelPicture = hotelPicture;    
     }     

    public int getId_hotel() {
        return id_hotel;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
     
}

