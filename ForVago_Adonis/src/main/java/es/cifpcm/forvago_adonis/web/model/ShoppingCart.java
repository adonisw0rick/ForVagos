/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

import es.cifpcm.forvago_adonis.web.db.HotelOfferDao;
import es.cifpcm.forvago_adonis.web.db.HotelOfferDaoImpl;
import es.cifpcm.forvago_adonis.web.model.hotel.HotelOffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ShoppingCart implements Serializable {
    private final List<HotelOffer> offers = new ArrayList<>();
    private String fecha1 = "";
    private String fecha2 = "";
    private int noches;
    private int id_municipio;
    private List<HotelOffer> Hoteles;
    
    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
    
    
    
    BigDecimal suma;
    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha1() {
        return fecha1;
    }
    

    public List<HotelOffer> getOffers() {
        return offers;
    }


    public int getNoches() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaentr = null;
        try {
            fechaentr = formatter.parse(this.fecha1);
        } catch (ParseException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fechasal = null;
        try {
            fechasal = formatter.parse(this.fecha2);
        } catch (ParseException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        long dif = fechasal.getTime() - fechaentr.getTime();
        long dias = dif/(1000*60*60*24);
        this.noches = (int) dias;
        return noches;
}

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }
        

    public BigDecimal getSuma() {
        return suma;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }
    
    
    public ShoppingCart() {
    }
    public void addOffer(HotelOffer offer) {        
        this.offers.add(offer);
    }    
    public void removeOffer(HotelOffer offer) {
        this.offers.remove(offer);
    }    
    public BigDecimal getTotal() {
        suma = new BigDecimal(0);
        for (HotelOffer elemento : this.offers) {
            suma = suma.add(elemento.price);
            //this.offers.map(o -> o.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return suma;
    } 
public List<HotelOffer> getByCriteriaHotelOffer() {
        
            HotelOfferDao hotelOfferDao = (HotelOfferDao) new HotelOfferDaoImpl();
        this.Hoteles = hotelOfferDao.selectByCriteria(this.id_municipio);
        //        Hoteles = hotelOfferDao.selectAll();
        
        return this.Hoteles;
    }
    private Date formatter(Date fechaEntrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 

