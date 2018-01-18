/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

import es.cifpcm.forvago_adonis.web.model.hotel.HotelOffer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class ShoppingCart implements Serializable {
    private final List<HotelOffer> offers = new ArrayList<>();
    BigDecimal suma;
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
} 

