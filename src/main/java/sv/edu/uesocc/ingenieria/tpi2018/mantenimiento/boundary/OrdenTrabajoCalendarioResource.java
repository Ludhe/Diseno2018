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
            try {
                List<OrdenTrabajoCalendario> list = null;                
                list = otcfl.findAll();
                if (list != null) {
                    return list;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new ArrayList<>();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<OrdenTrabajoCalendario> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (otcfl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = otcfl.findRange(first, pageSize);
                if (salida != null) {
                    return salida;                    
                }                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new ArrayList<>();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (otcfl != null) {
            try {
                return otcfl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        if (otcfl != null && id != null && id > 0) {
            try {
                OrdenTrabajoCalendario reg = otcfl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new OrdenTrabajoCalendario();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario create(OrdenTrabajoCalendario registro) {
        if (otcfl != null && registro != null) {
            try {
                OrdenTrabajoCalendario r = otcfl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new OrdenTrabajoCalendario();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario edit(OrdenTrabajoCalendario registro) {
        if (otcfl != null) {
            if (registro != null && registro.getIdOrdenTrabajoCalendario()!= null) {
                try {
                    OrdenTrabajoCalendario r = otcfl.editar(registro);
                    if (r != null && r.getIdOrdenTrabajoCalendario() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new OrdenTrabajoCalendario();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public OrdenTrabajoCalendario delete(
            @PathParam("id") Integer id
    ) {
        if (otcfl != null && id != null && id > 0) {
            try {
                OrdenTrabajoCalendario reg = otcfl.find(id);
                if(reg != null){
                    if (otcfl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new OrdenTrabajoCalendario();
    }

}