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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.TipoResponsableFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoResponsable;

/**
 *
 * @author rcarlos
 */
@Path("tiporesponsable")
public class TipoResponsableResources implements Serializable {

    @EJB
    private TipoResponsableFacadeLocal tipoResponsableFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoResponsable> findRange(
            @DefaultValue("0") @QueryParam("first") int firs,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (tipoResponsableFacade != null) {
                salida = tipoResponsableFacade.findRange(firs, pageSize);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida != null) {
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
            if (tipoResponsableFacade != null) {
                return tipoResponsableFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idtiporesponsable}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoResponsable findById(
            @PathParam("idtiporesponsable") Integer id
    ) {
        try {
            if (tipoResponsableFacade != null && id != null && !(id < 0)) {
                return tipoResponsableFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new TipoResponsable();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoResponsable create(TipoResponsable registro) {
        if (registro != null) {
            try {
                if (tipoResponsableFacade != null) {
                    TipoResponsable r = tipoResponsableFacade.crear(registro);
                    if (r != null && r.getIdTipoResponsable() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoResponsable();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoResponsable edit(TipoResponsable registro) {
        if (registro != null && registro.getIdTipoResponsable() != null) {
            try {
                if (tipoResponsableFacade != null) {
                    TipoResponsable r = tipoResponsableFacade.editar(registro);
                    if (r != null && r.getIdTipoResponsable() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoResponsable();
    }
    
    @DELETE
    @Path("delete/{idtiporesponsable}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("idtiporesponsable") Integer id
    ){
        try {
            if (tipoResponsableFacade!=null && id!=null) {
                TipoResponsable r = tipoResponsableFacade.find(id);
                return tipoResponsableFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

}
