/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.search;

import es.cifpcm.forvago_adonis.web.db.HotelOfferDao;
import es.cifpcm.forvago_adonis.web.db.HotelOfferDaoImpl;
import es.cifpcm.forvago_adonis.web.db.MunicipiosDao;
import es.cifpcm.forvago_adonis.web.db.MunicipiosDaoImpl;
import es.cifpcm.forvago_adonis.web.db.ProvinciasDao;
import es.cifpcm.forvago_adonis.web.db.ProvinciasDaoImpl;
import es.cifpcm.forvago_adonis.web.model.Municipio;
import es.cifpcm.forvago_adonis.web.model.Provincia;
import es.cifpcm.forvago_adonis.web.model.hotel.HotelOffer;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Adonis
 */
@Named(value = "hotelSearchBean")
@RequestScoped
public class HotelSearchBean {

    private List<Municipio> Municipios;
    private List<Provincia> Provincias;
    private List<HotelOffer> Hoteles;
    private int id_municipio = 1;
    private int id_provincia = -1;
    private int hotel_id;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    public void setHoteles(List<HotelOffer> Hoteles) {
        this.Hoteles = Hoteles;
    }

    public List<HotelOffer> getHoteles() {
        return Hoteles;
    }

    public void setMunicipios(List<Municipio> Municipios) {
        this.Municipios = Municipios;
    }

    public void setProvincias(List<Provincia> Provincias) {
        this.Provincias = Provincias;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    
    
    public int getId_municipio() {
        return id_municipio;
    }

    /**
     * Creates a new instance of HotelSearchBean
     */
    public int getId_provincia() {
        return id_provincia;
    }

    public HotelSearchBean() {
    }
    public List<Municipio> getMunicipios() {
        
        if(id_provincia < 0){
            MunicipiosDao municipiosDao = new MunicipiosDaoImpl();
        Municipios = municipiosDao.selectAll();
        return Municipios;
        }
        else{
            MunicipiosDao municipiosDao = new MunicipiosDaoImpl();
        Municipios = municipiosDao.selectAllByProv(id_provincia);
        return Municipios;
        }
    }
    public List<Provincia> getProvincias() {
        
            ProvinciasDao provinciasDao = (ProvinciasDao) new ProvinciasDaoImpl();
        Provincias = provinciasDao.selectAll();
        return Provincias;
    }
    public List<HotelOffer> getHotelOffer() {
        
            HotelOfferDao hotelOfferDao = (HotelOfferDao) new HotelOfferDaoImpl();
        Hoteles = hotelOfferDao.selectAll();
        return Hoteles;
    }
    public List<HotelOffer> getByCriteriaHotelOffer() {
        
            HotelOfferDao hotelOfferDao = (HotelOfferDao) new HotelOfferDaoImpl();
        this.Hoteles = hotelOfferDao.selectByCriteria(this.id_municipio);
        //        Hoteles = hotelOfferDao.selectAll();
        
        return this.Hoteles;
    }
}
