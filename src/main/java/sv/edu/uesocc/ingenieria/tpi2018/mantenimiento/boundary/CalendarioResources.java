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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.CalendarioFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Calendario;

/**
 *
 * @author dmmaga
 */
@Path("calendario")
public class CalendarioResources {

    @EJB
    private CalendarioFacadeLocal calendarioFacade;

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario create(Calendario registro) {
        if (registro != null) {
            try {
                if (calendarioFacade != null) {
                    Calendario r = calendarioFacade.crear(registro);
                    if (r != null && r.getIdFecha() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Calendario();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario edit(Calendario registro) {
        if (registro != null && registro.getIdFecha() != null) {
            try {
                if (calendarioFacade != null) {
                    Calendario r = calendarioFacade.editar(registro);
                    if (r != null && r.getIdFecha() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Calendario();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (calendarioFacade != null && id != null && !(id < 0)) {
                Calendario r = calendarioFacade.find(id);
                return calendarioFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Calendario> findAll() {
        List salida = null;
        try {
            if (calendarioFacade != null) {
                salida = calendarioFacade.findAll();
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
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Calendario> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (calendarioFacade != null) {
                salida = calendarioFacade.findRange(first, pageSize);
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
            if (calendarioFacade != null) {
                return calendarioFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idfecha}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario findById(
            @PathParam("idfecha") Integer id
    ) {
        try {
            if (calendarioFacade != null && id != null && !(id < 0)) {
                return calendarioFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Calendario();
    }

}
