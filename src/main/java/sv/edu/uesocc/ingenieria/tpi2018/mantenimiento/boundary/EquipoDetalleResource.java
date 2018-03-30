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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.EquipoDetalleFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.EquipoDetalle;

/**
 *
 * @author dmmaga
 */
@Path("equipodetalle")
public class EquipoDetalleResource implements Serializable {

    @EJB
    private EquipoDetalleFacadeLocal edfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<EquipoDetalle> findAll() {
        if (edfl != null) {
            List<EquipoDetalle> list = new ArrayList<>();
            try {
                list = edfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<EquipoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (edfl != null) {
            try {
                List<EquipoDetalle> list = null;
                list = edfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idequipodetalle}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EquipoDetalle findById(
            @PathParam("idequipodetalle") Integer id
    ) {
        if (edfl != null) {
            EquipoDetalle reg = null;
            try {
                reg = edfl.find(id);
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
        if (edfl != null) {
            try {
                return edfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public EquipoDetalle delete(
            @PathParam("id") Integer id
    ) {
        if (edfl != null) {
            try {
                EquipoDetalle reg = edfl.find(id);
                if(reg != null){
                    edfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public EquipoDetalle create(EquipoDetalle registro){
        if (registro != null && registro.getIdEquipoDetalle()== null) {
            try {
                if (edfl != null) {
                    EquipoDetalle reg = edfl.crear(registro);
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
    public EquipoDetalle edit(EquipoDetalle reg) {        
        if (edfl != null) {
            if (reg.getIdMarca() != null) {
                //Verificar que exista ese registro
                try {
                    EquipoDetalle regVerificado = edfl.find(reg.getIdEquipoDetalle());
                    if (regVerificado != null) {
                        if (edfl.edit(reg)) {
                            return edfl.find(reg.getIdEquipoDetalle());
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