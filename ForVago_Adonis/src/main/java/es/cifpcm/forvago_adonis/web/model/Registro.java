/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

import es.cifpcm.forvago_adonis.web.db.RegistroDao;
import es.cifpcm.forvago_adonis.web.db.RegistroDaoImpl;
import java.io.Serializable;

/**
 *
 * @author Adonis
 */
public class Registro implements Serializable{
    private String username;
    private int telefono;
    private String correo;
    private String password;

    public String getUsername() {
        return username;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void Registra(){
        if(this.username == null){
            
        this.username = "Adonis";
        this.correo = "ado@gmail.com";
        this.password = "123456";
        }
        RegistroDao RegistroDao = (RegistroDao) new RegistroDaoImpl();
        RegistroDao.addUser(this.getUsername(), this.getUsername(), this.getCorreo(), this.getPassword());
    }
}
