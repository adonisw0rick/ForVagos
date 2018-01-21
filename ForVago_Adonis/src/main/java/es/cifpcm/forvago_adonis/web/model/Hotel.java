/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

/**
 *
 * @author Adonis
 */
public class Hotel {
    private int hotel_id;
    private String name;
    private float price;
    private String hotel_picture;
    private int id_municipio;

    public int getHotel_id() {
        return hotel_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getHotel_picture() {
        return hotel_picture;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setHotel_picture(String hotel_picture) {
        this.hotel_picture = hotel_picture;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
    
    
}
