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
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.PrioridadFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Prioridad;

/**
 *
 * @author jcpleitez
 */
@Path("prioridad")
public class PrioridadRest {
    
    @EJB
    private PrioridadFacadeLocal pfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Prioridad> findAll() {
        if (pfl != null) {
            List<Prioridad> list = new ArrayList<>();
            try {
                list = pfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Prioridad> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (pfl != null) {
            try {
                List<Prioridad> list = null;
                list = pfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idprioridad}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Prioridad findById(
            @PathParam("idprioridad") Integer id
    ) {
        if (pfl != null) {
            Prioridad reg = null;
            try {
                reg = pfl.find(id);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return reg;
        }
        return null;
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        try {
            if (pfl != null) {
                return pfl.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Prioridad delete(
            @PathParam("id") Integer id
    ) {
        try {
            Prioridad reg = null;
            if (pfl != null) {
                reg = pfl.find(id);
                if(reg != null){
                    pfl.remove(reg);
                }
                return reg;
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public Prioridad create(Prioridad registro){
        if (registro != null && registro.getIdPrioridad()== null) {
            try {
                if (pfl != null) {
                    Prioridad reg = pfl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @PUT    
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Prioridad edit(Prioridad reg) {        
        if (pfl != null) {
            if (reg.getIdPrioridad() != null) {
                //Verificar que exista ese registro
                try {
                    Prioridad regVerificado = pfl.find(reg.getIdPrioridad());
                    if (regVerificado != null) {
                        if (pfl.edit(reg)) {
                            return pfl.find(reg.getIdPrioridad());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return null;
    }
    
}
