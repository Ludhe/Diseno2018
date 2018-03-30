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
            List<EstadoMantenimientoDetalle> list = new ArrayList<>();
            try {
                list = emdfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<EstadoMantenimientoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (emdfl != null) {
            try {
                List<EstadoMantenimientoDetalle> list = null;
                list = emdfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idestadomantenimientodetalle}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle findById(
            @PathParam("idestadomantenimientodetalle") Integer id
    ) {
        if (emdfl != null) {
            EstadoMantenimientoDetalle reg = null;
            try {
                reg = emdfl.find(id);
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
        if (emdfl != null) {
            try {
                return emdfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EstadoMantenimientoDetalle delete(
            @PathParam("id") Integer id
    ) {
        if (emdfl != null) {
            try {
                EstadoMantenimientoDetalle reg = emdfl.find(id);
                if(reg != null){
                    emdfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public EstadoMantenimientoDetalle create(EstadoMantenimientoDetalle registro){
        if (registro != null && registro.getIdEstadoMantenimientoDetalle()== null) {
            try {
                if (emdfl != null) {
                    EstadoMantenimientoDetalle reg = emdfl.crear(registro);
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
    public EstadoMantenimientoDetalle edit(EstadoMantenimientoDetalle reg) {        
        if (emdfl != null) {
            if (reg.getIdEstadoMantenimientoDetalle()!= null) {
                //Verificar que exista ese registro
                try {
                    EstadoMantenimientoDetalle regVerificado = emdfl.find(reg.getIdEstadoMantenimientoDetalle());
                    if (regVerificado != null) {
                        if (emdfl.edit(reg)) {
                            return emdfl.find(reg.getIdEstadoMantenimientoDetalle());
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