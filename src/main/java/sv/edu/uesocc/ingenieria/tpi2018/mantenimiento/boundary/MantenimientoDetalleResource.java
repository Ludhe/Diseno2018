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
            try {
                List<MantenimientoDetalle> list = null;                
                list = mdfl.findAll();
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
    public List<MantenimientoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (mdfl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = mdfl.findRange(first, pageSize);
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
        if (mdfl != null) {
            try {
                return mdfl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        if (mdfl != null && id != null && id > 0) {
            try {
                MantenimientoDetalle reg = mdfl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new MantenimientoDetalle();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle create(MantenimientoDetalle registro) {
        if (mdfl != null && registro != null) {
            try {
                MantenimientoDetalle r = mdfl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new MantenimientoDetalle();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle edit(MantenimientoDetalle registro) {
        if (mdfl != null) {
            if (registro != null && registro.getIdMantenimientoDetalle()!= null) {
                try {
                    MantenimientoDetalle r = mdfl.editar(registro);
                    if (r != null && r.getIdMantenimientoDetalle() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new MantenimientoDetalle();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public MantenimientoDetalle delete(
            @PathParam("id") Integer id
    ) {
        if (mdfl != null && id != null && id > 0) {
            try {
                MantenimientoDetalle reg = mdfl.find(id);
                if(reg != null){
                    if (mdfl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new MantenimientoDetalle();
    }

}
