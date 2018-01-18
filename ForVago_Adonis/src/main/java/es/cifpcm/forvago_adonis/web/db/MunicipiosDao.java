/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.db;
import es.cifpcm.forvago_adonis.web.model.Municipio;
import java.util.List;
/**
 *
 * @author Adonis
 */
public interface MunicipiosDao {
    public List<Municipio> selectAll();
    public List<Municipio> selectAllByProv(int id_provincia);
}
