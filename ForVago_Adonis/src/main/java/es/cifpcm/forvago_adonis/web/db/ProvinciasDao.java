/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;

import es.cifpcm.forvago_adonis.web.model.Provincia;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface ProvinciasDao {
    public List<Provincia> selectAll();
}
