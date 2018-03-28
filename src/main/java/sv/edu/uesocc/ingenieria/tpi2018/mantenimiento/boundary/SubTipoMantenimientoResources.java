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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.SubTipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.SubTipoMantenimiento;

/**
 *
 * @author dmmaga
 */
@Path("subtipomtto")
public class SubTipoMantenimientoResources implements Serializable {

    @EJB
    private SubTipoMantenimientoFacadeLocal subTipoMttoFacade;

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento create(SubTipoMantenimiento registro) {
        if (registro != null) {
            try {
                if (subTipoMttoFacade != null) {
                    SubTipoMantenimiento r = subTipoMttoFacade.crear(registro);
                    if (r != null && r.getIdSubTipoMantenimiento() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new SubTipoMantenimiento();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento edit(SubTipoMantenimiento registro) {
        if (registro != null && registro.getIdSubTipoMantenimiento() != null) {
            try {
                if (subTipoMttoFacade != null) {
                    SubTipoMantenimiento r = subTipoMttoFacade.editar(registro);
                    if (r != null && r.getIdSubTipoMantenimiento() != null) {
                        return r;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new SubTipoMantenimiento();
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public boolean delete(
            @PathParam("id") Integer id
    ) {
        try {
            if (subTipoMttoFacade != null && id != null && !(id < 0)) {
                SubTipoMantenimiento r = subTipoMttoFacade.find(id);
                return subTipoMttoFacade.remove(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<SubTipoMantenimiento> findAll() {
        List salida = null;
        try {
            if (subTipoMttoFacade != null) {
                salida = subTipoMttoFacade.findAll();
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
    public List<SubTipoMantenimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        List salida = null;
        try {
            if (subTipoMttoFacade != null) {
                salida = subTipoMttoFacade.findRange(first, pageSize);
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
            if (subTipoMttoFacade != null) {
                return subTipoMttoFacade.count();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return 0;
    }

    @GET
    @Path("{idsubtipomtto}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento findById(
            @PathParam("idsubtipomtto") Integer id
    ) {
        try {
            if (subTipoMttoFacade != null && id != null && !(id < 0)) {
                return subTipoMttoFacade.find(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return new SubTipoMantenimiento();
    }

}
