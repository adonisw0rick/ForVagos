/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.Registro;

/**
 *
 * @author Adonis
 */
public interface RegistroDao {
    public void addUser(String first_name, String last_name, String email, String password);
}
