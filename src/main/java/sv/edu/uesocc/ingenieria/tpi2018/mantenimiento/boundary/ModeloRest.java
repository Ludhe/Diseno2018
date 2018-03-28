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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.ModeloFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Modelo;

/**
 *
 * @author jcpleitez
 */
@Path("modelo")
public class ModeloRest  implements Serializable {
    
    @EJB
    private ModeloFacadeLocal mdfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Modelo> findAll() {
        if (mdfl != null) {
            List<Modelo> list = new ArrayList<>();
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
    public List<Modelo> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (mdfl != null) {
            try {
                List<Modelo> list = null;
                list = mdfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idmodelo}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Modelo findById(
            @PathParam("idmodelo") Integer id
    ) {
        if (mdfl != null) {
            Modelo reg = null;
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
    public Modelo delete(
            @PathParam("id") Integer id
    ) {
        if (mdfl != null) {
            try {
                Modelo reg = mdfl.find(id);
                if(reg != null){
                    mdfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public Modelo create(Modelo registro){
        if (registro != null && registro.getIdModelo()== null) {
            try {
                if (mdfl != null) {
                    Modelo reg = mdfl.crear(registro);
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
    public Modelo edit(Modelo reg) {        
        if (mdfl != null) {
            if (reg.getIdModelo() != null) {
                //Verificar que exista ese registro
                try {
                    Modelo regVerificado = mdfl.find(reg.getIdModelo());
                    if (regVerificado != null) {
                        if (mdfl.edit(reg)) {
                            return mdfl.find(reg.getIdModelo());
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

