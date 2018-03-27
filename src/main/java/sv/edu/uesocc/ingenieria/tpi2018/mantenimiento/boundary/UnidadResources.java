/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.UnidadFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Unidad;


/**
 *
 * @author dmmaga
 */
@Path("unidad")
public class UnidadResources {
    
    @EJB
    private UnidadFacadeLocal unidadFacade;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Unidad> findAll() {
        List salida = null;
        try {
            if (unidadFacade != null) {
                salida = unidadFacade.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida==null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }
    
}
