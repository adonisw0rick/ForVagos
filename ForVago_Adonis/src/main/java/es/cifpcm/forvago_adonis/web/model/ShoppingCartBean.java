/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.model;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author alumno
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean extends ShoppingCart implements Serializable {

    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {
    }
    public String getTotalAsString(){
        return NumberFormat.getCurrencyInstance().format(getTotal());
    }
}
