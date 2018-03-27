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
    
    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad create(Unidad registro) {
        if (registro != null) {
            try {
                if (unidadFacade != null) {
                    Unidad r = unidadFacade.crear(registro);
                    if (r != null && r.getIdUnidad() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Unidad();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad edit(Unidad registro) {
        if (registro != null && registro.getIdUnidad() != null) {
            try {
                if (unidadFacade != null) {
                    Unidad r = unidadFacade.editar(registro);
                    if (r != null && r.getIdUnidad() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Unidad();
    }
    
    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (unidadFacade != null && id != null && !(id < 0)) {
                Unidad r = unidadFacade.find(id);
                return unidadFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    
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
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Unidad> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (unidadFacade != null) {
                salida = unidadFacade.findRange(first, pageSize);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        try {
            if (unidadFacade != null) {
                return unidadFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }
    
    @GET
    @Path("{idUnidad}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad findById(
            @PathParam("idUnidad") Integer id
    ) {
        try {
            if (unidadFacade != null && id != null && !(id < 0)) {
                return unidadFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Unidad();
    }
    

}
