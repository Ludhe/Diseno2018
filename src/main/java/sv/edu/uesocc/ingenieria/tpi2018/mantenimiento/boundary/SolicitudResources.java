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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.SolicitudFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Solicitud;

/**
 *
 * @author rcarlos
 */
@Path("solicitud")
public class SolicitudResources implements Serializable {

    @EJB
    private SolicitudFacadeLocal solicitudFacade;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Solicitud> findAll() {
        List salida;
        try {
            if (solicitudFacade != null) {
                salida = solicitudFacade.findAll();
                return salida;
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Solicitud> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida;
        try {
            if (solicitudFacade != null) {
                salida = solicitudFacade.findRange(first, pageSize);
                return salida;
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ArrayList();
    }

    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        try {
            if (solicitudFacade != null) {
                return solicitudFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idsolicitud}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud findById(
            @PathParam("idsolicitud") Integer id
    ) {
        try {
            if (solicitudFacade != null && id != null && id > 0) {
                return solicitudFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Solicitud();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud create(Solicitud registro) {
        if (registro != null) {
            try {
                if (solicitudFacade != null) {
                    Solicitud r = solicitudFacade.crear(registro);
                    if (r != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Solicitud();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud edit(Solicitud registro) {
        if (registro != null && registro.getIdSolicitud() != null) {
            try {
                if (solicitudFacade != null) {
                    Solicitud r = solicitudFacade.editar(registro);
                    if (r != null && r.getIdSolicitud() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Solicitud();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitud delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (solicitudFacade != null && id != null && !(id < 0)) {
                Solicitud r = solicitudFacade.find(id);
                if (solicitudFacade.remove(r)) {
                    return r;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Solicitud();
    }

}
