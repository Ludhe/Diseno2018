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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.TipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoMantenimiento;

/**
 *
 * @author dmmaga
 */
@Path("tipomantenimiento")
public class TipoMantenimientoResources implements Serializable {

    @EJB
    private TipoMantenimientoFacadeLocal tmfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoMantenimiento> findAll() {
        if (tmfl != null) {

            try {
                List<TipoMantenimiento> list;
                list = tmfl.findAll();
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoMantenimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (tmfl != null) {
            try {
                List<TipoMantenimiento> list;
                list = tmfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Path("{idtipomantenimiento}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoMantenimiento findById(
            @PathParam("idtipomantenimiento") Integer id
    ) {
        if (tmfl != null) {
            TipoMantenimiento reg = null;
            try {
                if (id != null && id > 0) {
                    reg = tmfl.find(id);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (tmfl != null) {
            try {
                return tmfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return 0;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoMantenimiento delete(
            @PathParam("id") Integer id
    ) {
        if (tmfl != null) {
            try {
                TipoMantenimiento reg = tmfl.find(id);
                if (reg != null) {
                    tmfl.remove(reg);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new TipoMantenimiento();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoMantenimiento create(TipoMantenimiento registro) {
        if (registro != null && registro.getIdTipoMantenimiento() == null) {
            try {
                if (tmfl != null) {
                    TipoMantenimiento reg = tmfl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new TipoMantenimiento();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoMantenimiento edit(TipoMantenimiento reg) {
        if (tmfl != null) {
            if (reg.getIdTipoMantenimiento() != null) {
                //Verificar que exista ese registro
                try {
                    TipoMantenimiento regVerificado = tmfl.find(reg.getIdTipoMantenimiento());
                    if (regVerificado != null) {
                        if (tmfl.edit(reg)) {
                            return tmfl.find(reg.getIdTipoMantenimiento());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return new TipoMantenimiento();
    }

}
