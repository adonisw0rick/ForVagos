/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.hotel.HotelOffer;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface HotelOfferDao {
    public List<HotelOffer> selectAll();
    public List<HotelOffer> selectByCriteria(int entero);
    public HotelOffer insert();
    public HotelOffer update();
    public HotelOffer delete();
}
