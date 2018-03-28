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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.EstadoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Estado;

/**
 *
 * @author jcpleitez
 */
@Path("estado")
public class EstadoRest  implements Serializable {
    
    @EJB
    private EstadoFacadeLocal efl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Estado> findAll() {
        if (efl != null) {
            List<Estado> list = new ArrayList<>();
            try {
                list = efl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Estado> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (efl != null) {
            try {
                List<Estado> list = null;
                list = efl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idestado}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Estado findById(
            @PathParam("idestado") Integer id
    ) {
        if (efl != null) {
            Estado reg = null;
            try {
                reg = efl.find(id);
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
        try {
            if (efl != null) {
                return efl.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Estado delete(
            @PathParam("id") Integer id
    ) {
        try {
            Estado reg = null;
            if (efl != null) {
                reg = efl.find(id);
                if(reg != null){
                    efl.remove(reg);
                }
                return reg;
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public Estado create(Estado registro){
        if (registro != null && registro.getIdEstado()== null) {
            try {
                if (efl != null) {
                    Estado reg = efl.crear(registro);
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
    public Estado edit(Estado reg) {        
        if (efl != null) {
            if (reg.getIdEstado() != null) {
                //Verificar que exista ese registro
                try {
                    Estado regVerificado = efl.find(reg.getIdEstado());
                    if (regVerificado != null) {
                        if (efl.edit(reg)) {
                            return efl.find(reg.getIdEstado());
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
