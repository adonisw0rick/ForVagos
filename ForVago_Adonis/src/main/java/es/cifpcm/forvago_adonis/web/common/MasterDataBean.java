/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_adonis.web.common;

import es.cifpcm.forvago_adonis.web.db.MunicipiosDao;
import es.cifpcm.forvago_adonis.web.db.MunicipiosDaoImpl;
import es.cifpcm.forvago_adonis.web.db.ProvinciasDao;
import es.cifpcm.forvago_adonis.web.db.ProvinciasDaoImpl;
import es.cifpcm.forvago_adonis.web.model.Municipio;
import es.cifpcm.forvago_adonis.web.model.Provincia;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Adonis
 */
@Named(value = "masterDataBean")
@ApplicationScoped
public class MasterDataBean {

    /**
     * Creates a new instance of MasterDataBean
     */
    
    private List<Municipio> Municipios;
    private List<Provincia> Provincias;
    public MasterDataBean() {
    }
    
    public List<Municipio> getMunicipios() {
        MunicipiosDao municipiosDao = new MunicipiosDaoImpl();
        Municipios = municipiosDao.selectAll();
        return Municipios;
    }
    
    public List<Provincia> getProvincias() {
        ProvinciasDao provinciasDao = new ProvinciasDaoImpl();
        Provincias = provinciasDao.selectAll();
        return Provincias;
    }
    
}
