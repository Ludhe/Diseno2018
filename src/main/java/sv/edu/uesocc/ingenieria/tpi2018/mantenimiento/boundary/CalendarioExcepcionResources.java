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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.CalendarioExcepcionFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.CalendarioExcepcion;

/**
 *
 * @author rcarlos
 */
@Path("calendarioexcepciones")
public class CalendarioExcepcionResources implements Serializable {

    @EJB
    private CalendarioExcepcionFacadeLocal calendarioExcepcionFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<CalendarioExcepcion> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (calendarioExcepcionFacade != null) {
                salida = calendarioExcepcionFacade.findRange(first, pageSize);
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
            if (calendarioExcepcionFacade != null) {
                return calendarioExcepcionFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public CalendarioExcepcion findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        try {
            if (calendarioExcepcionFacade != null && id != null && !(id < 0)) {
                return calendarioExcepcionFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new CalendarioExcepcion();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public CalendarioExcepcion create(CalendarioExcepcion registro) {
        if (registro != null) {
            try {
                if (calendarioExcepcionFacade != null) {
                    CalendarioExcepcion r = calendarioExcepcionFacade.crear(registro);
                    if (r != null && r.getIdExcepcion() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new CalendarioExcepcion();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public CalendarioExcepcion edit(CalendarioExcepcion registro) {
        if (registro != null && registro.getIdExcepcion() != null) {
            try {
                if (calendarioExcepcionFacade != null) {
                    CalendarioExcepcion r = calendarioExcepcionFacade.editar(registro);
                    if (r != null && r.getIdExcepcion() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new CalendarioExcepcion();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (calendarioExcepcionFacade != null && id != null && !(id < 0)) {
                CalendarioExcepcion r = calendarioExcepcionFacade.find(id);
                return calendarioExcepcionFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

}
