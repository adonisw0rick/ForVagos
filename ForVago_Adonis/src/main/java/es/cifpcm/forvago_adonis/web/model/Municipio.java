/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;
import java.io.Serializable;
/**
 *
 * @author Adonis
 */
public class Municipio implements Serializable {
    private int id_municipio;
    private int id_provincia;
    private int cod_municipio;
    private int dc;
    private String nombre;

    public int getId_municipio() {
        return id_municipio;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public int getCod_municipio() {
        return cod_municipio;
    }

    public int getDc() {
        return dc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public void setCod_municipio(int cod_municipio) {
        this.cod_municipio = cod_municipio;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
