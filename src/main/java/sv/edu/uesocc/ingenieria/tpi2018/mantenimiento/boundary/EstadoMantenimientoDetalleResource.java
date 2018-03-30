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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.EstadoMantenimientoDetalleFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.EstadoMantenimientoDetalle;

/**
 *
 * @author dmmaga
 */
@Path("estadomantenimientodetalle")
public class EstadoMantenimientoDetalleResource implements Serializable {

    @EJB
    private EstadoMantenimientoDetalleFacadeLocal emdfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<EstadoMantenimientoDetalle> findAll() {
        if (emdfl != null) {
            try {
                List<EstadoMantenimientoDetalle> list = null;                
                list = emdfl.findAll();
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
    public List<EstadoMantenimientoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (emdfl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = emdfl.findRange(first, pageSize);
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
        if (emdfl != null) {
            try {
                return emdfl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        if (emdfl != null && id != null && id > 0) {
            try {
                EstadoMantenimientoDetalle reg = emdfl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new EstadoMantenimientoDetalle();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle create(EstadoMantenimientoDetalle registro) {
        if (emdfl != null && registro != null) {
            try {
                EstadoMantenimientoDetalle r = emdfl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new EstadoMantenimientoDetalle();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle edit(EstadoMantenimientoDetalle registro) {
        if (emdfl != null) {
            if (registro != null && registro.getIdEstadoMantenimientoDetalle()!= null) {
                try {
                    EstadoMantenimientoDetalle r = emdfl.editar(registro);
                    if (r != null && r.getIdEstadoMantenimientoDetalle() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new EstadoMantenimientoDetalle();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle delete(
            @PathParam("id") Integer id
    ) {
        if (emdfl != null && id != null && id > 0) {
            try {
                EstadoMantenimientoDetalle reg = emdfl.find(id);
                if(reg != null){
                    if (emdfl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new EstadoMantenimientoDetalle();
    }

}