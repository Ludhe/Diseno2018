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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.OrdenTrabajoCalendarioFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.OrdenTrabajoCalendario;

/**
 *
 * @author dmmaga
 */
@Path("ordentrabajocalendario")
public class OrdenTrabajoCalendarioResource implements Serializable {

    @EJB
    private OrdenTrabajoCalendarioFacadeLocal otcfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<OrdenTrabajoCalendario> findAll() {
        if (otcfl != null) {
            List<OrdenTrabajoCalendario> list = new ArrayList<>();
            try {
                list = otcfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<OrdenTrabajoCalendario> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (otcfl != null) {
            try {
                List<OrdenTrabajoCalendario> list = null;
                list = otcfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idordentrabajocalendario}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario findById(
            @PathParam("idordentrabajocalendario") Integer id
    ) {
        if (otcfl != null) {
            OrdenTrabajoCalendario reg = null;
            try {
                reg = otcfl.find(id);
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
        if (otcfl != null) {
            try {
                return otcfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario delete(
            @PathParam("id") Integer id
    ) {
        if (otcfl != null) {
            try {
                OrdenTrabajoCalendario reg = otcfl.find(id);
                if(reg != null){
                    otcfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public OrdenTrabajoCalendario create(OrdenTrabajoCalendario registro){
        if (registro != null && registro.getIdOrdenTrabajoCalendario()== null) {
            try {
                if (otcfl != null) {
                    OrdenTrabajoCalendario reg = otcfl.crear(registro);
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
    public OrdenTrabajoCalendario edit(OrdenTrabajoCalendario reg) {        
        if (otcfl != null) {
            if (reg.getIdOrdenTrabajoCalendario()!= null) {
                //Verificar que exista ese registro
                try {
                    OrdenTrabajoCalendario regVerificado = otcfl.find(reg.getIdOrdenTrabajoCalendario());
                    if (regVerificado != null) {
                        if (otcfl.edit(reg)) {
                            return otcfl.find(reg.getIdOrdenTrabajoCalendario());
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