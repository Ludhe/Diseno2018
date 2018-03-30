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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MantenimientoDetalleFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.MantenimientoDetalle;

/**
 *
 * @author dmmaga
 */
@Path("mantenimientodetalle")
public class MantenimientoDetalleResource implements Serializable {

    @EJB
    private MantenimientoDetalleFacadeLocal mdfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<MantenimientoDetalle> findAll() {
        if (mdfl != null) {
            List<MantenimientoDetalle> list = new ArrayList<>();
            try {
                list = mdfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<MantenimientoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (mdfl != null) {
            try {
                List<MantenimientoDetalle> list = null;
                list = mdfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idmantenimientodetalle}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle findById(
            @PathParam("idmantenimientodetalle") Integer id
    ) {
        if (mdfl != null) {
            MantenimientoDetalle reg = null;
            try {
                reg = mdfl.find(id);
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
        if (mdfl != null) {
            try {
                return mdfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle delete(
            @PathParam("id") Integer id
    ) {
        if (mdfl != null) {
            try {
                MantenimientoDetalle reg = mdfl.find(id);
                if (reg != null) {
                    mdfl.remove(reg);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle create(MantenimientoDetalle registro) {
        if (registro != null && registro.getIdMantenimientoDetalle() == null) {
            try {
                if (mdfl != null) {
                    MantenimientoDetalle reg = mdfl.crear(registro);
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
    public MantenimientoDetalle edit(MantenimientoDetalle reg) {
        if (mdfl != null) {
            if (reg.getIdMantenimientoDetalle() != null) {
                //Verificar que exista ese registro
                try {
                    MantenimientoDetalle regVerificado = mdfl.find(reg.getIdMantenimientoDetalle());
                    if (regVerificado != null) {
                        if (mdfl.edit(reg)) {
                            return mdfl.find(reg.getIdMantenimientoDetalle());
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
