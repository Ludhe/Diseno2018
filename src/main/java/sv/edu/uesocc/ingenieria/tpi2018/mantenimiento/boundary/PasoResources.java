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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.PasoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Paso;

/**
 *
 * @author rcarlos
 */
@Path("paso")
public class PasoResources implements Serializable {

    @EJB
    private PasoFacadeLocal pasoFacade;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Paso> findAll() {
        List salida;
        try {
            if (pasoFacade != null) {
                salida = pasoFacade.findAll();
                return salida;
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Paso> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (pasoFacade != null) {
                salida = pasoFacade.findRange(first, pageSize);
                return salida;
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new ArrayList();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        try {
            if (pasoFacade != null) {
                return pasoFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idpaso}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Paso findById(
            @PathParam("idpaso") Integer id
    ) {
        try {
            if (pasoFacade != null && id != null && id > 0) {
                return pasoFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Paso();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Paso create(Paso registro) {
        if (registro != null) {
            try {
                if (pasoFacade != null) {
                    Paso r = pasoFacade.crear(registro);
                    if (r != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Paso();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Paso edit(Paso registro) {
        if (registro != null && registro.getIdPaso() != null) {
            try {
                if (pasoFacade != null) {
                    Paso r = pasoFacade.editar(registro);
                    if (r != null && r.getIdPaso() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Paso();
    }

    @DELETE
    @Path("{idpaso}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Paso remove(
            @PathParam("idpaso") Integer id
    ) {
        try {
            if (pasoFacade != null && id != null) {
                Paso r = pasoFacade.find(id);
                if (pasoFacade.remove(r)) {
                    return r;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new Paso();
    }
}
