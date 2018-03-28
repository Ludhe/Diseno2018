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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.OrdenTrabajoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.OrdenTrabajo;

/**
 *
 * @author jcpleitez
 */
@Path("ordentrabajo")
public class OrdenTrabajoRest implements Serializable {
    
    @EJB
    private OrdenTrabajoFacadeLocal otfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<OrdenTrabajo> findAll() {
        if (otfl != null) {
            List<OrdenTrabajo> list = new ArrayList<>();
            try {
                list = otfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<OrdenTrabajo> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (otfl != null) {
            try {
                List<OrdenTrabajo> list = null;
                list = otfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idordentrabajo}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajo findById(
            @PathParam("idordentrabajo") Integer id
    ) {
        if (otfl != null) {
            OrdenTrabajo reg = null;
            try {
                reg = otfl.find(id);
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
        if (otfl != null) {
            try {
                return otfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajo delete(
            @PathParam("id") Integer id
    ) {
        if (otfl != null) {
            try {
                OrdenTrabajo reg = otfl.find(id);
                if(reg != null){
                    otfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public OrdenTrabajo create(OrdenTrabajo registro){
        if (registro != null && registro.getIdOrdenTrabajo()== null) {
            try {
                if (otfl != null) {
                    OrdenTrabajo reg = otfl.crear(registro);
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
    public OrdenTrabajo edit(OrdenTrabajo reg) {        
        if (otfl != null) {
            if (reg.getIdOrdenTrabajo() != null) {
                //Verificar que exista ese registro
                try {
                    OrdenTrabajo regVerificado = otfl.find(reg.getIdOrdenTrabajo());
                    if (regVerificado != null) {
                        if (otfl.edit(reg)) {
                            return otfl.find(reg.getIdOrdenTrabajo());
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
