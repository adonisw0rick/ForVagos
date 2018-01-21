/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

import es.cifpcm.forvago_adonis.web.db.RegistroDao;
import es.cifpcm.forvago_adonis.web.db.RegistroDaoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Adonis
 */
@Named(value = "registroBean")
@SessionScoped
public class RegistroBean extends Registro implements Serializable {

    /**
     * Creates a new instance of RegistroBean
     */
    public RegistroBean() {
    }
    
}
