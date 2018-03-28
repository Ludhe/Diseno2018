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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.TipoParteFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoParte;

/**
 *
 * @author dmmaga
 */
@Path("tipoparte")
public class TipoParteResources implements Serializable {

    @EJB
    private TipoParteFacadeLocal tipoParteFacade;

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoParte create(TipoParte registro) {
        if (registro != null) {
            try {
                if (tipoParteFacade != null) {
                    TipoParte r = tipoParteFacade.crear(registro);
                    if (r != null && r.getIdTipoParte() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoParte();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoParte edit(TipoParte registro) {
        if (registro != null && registro.getIdTipoParte() != null) {
            try {
                if (tipoParteFacade != null) {
                    TipoParte r = tipoParteFacade.editar(registro);
                    if (r != null && r.getIdTipoParte() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new TipoParte();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (tipoParteFacade != null && id != null && !(id < 0)) {
                TipoParte r = tipoParteFacade.find(id);
                return tipoParteFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoParte> findAll() {
        List salida = null;
        try {
            if (tipoParteFacade != null) {
                salida = tipoParteFacade.findAll();
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
    public List<TipoParte> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (tipoParteFacade != null) {
                salida = tipoParteFacade.findRange(first, pageSize);
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
            if (tipoParteFacade != null) {
                return tipoParteFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idtipoparte}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoParte findById(
            @PathParam("idtipoparte") Integer id
    ) {
        try {
            if (tipoParteFacade != null && id != null && !(id < 0)) {
                return tipoParteFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new TipoParte();
    }

}
