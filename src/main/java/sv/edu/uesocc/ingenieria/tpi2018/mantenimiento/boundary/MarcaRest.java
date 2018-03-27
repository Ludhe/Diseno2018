/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Marca;

/**
 *
 * @author jcpleitez
 */
@Path("marca")
public class MarcaRest implements Serializable{
    
    @EJB
    private MarcaFacadeLocal mfl;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public List<Marca> findAll(){
        if(mfl != null){
            List<Marca> list = new ArrayList<>();
            try {
                list = mfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;            
        }
        return new ArrayList<>();
    }
    
}
