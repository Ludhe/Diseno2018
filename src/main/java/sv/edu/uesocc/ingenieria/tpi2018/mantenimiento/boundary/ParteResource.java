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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.ParteFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Parte;

/**
 *
 * @author dmmaga
 */
@Path("parte")
public class ParteResource implements Serializable {

    @EJB
    private ParteFacadeLocal pfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Parte> findAll() {
        if (pfl != null) {
            List<Parte> list = new ArrayList<>();
            try {
                list = pfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Parte> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (pfl != null) {
            try {
                List<Parte> list = null;
                list = pfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idparte}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Parte findById(
            @PathParam("idparte") Integer id
    ) {
        if (pfl != null) {
            Parte reg = null;
            try {
                reg = pfl.find(id);
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
        if (pfl != null) {
            try {
                return pfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Parte delete(
            @PathParam("id") Integer id
    ) {
        if (pfl != null) {
            try {
                Parte reg = pfl.find(id);
                if(reg != null){
                    pfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public Parte create(Parte registro){
        if (registro != null && registro.getIdParte()== null) {
            try {
                if (pfl != null) {
                    Parte reg = pfl.crear(registro);
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
    public Parte edit(Parte reg) {        
        if (pfl != null) {
            if (reg.getIdParte()!= null) {
                //Verificar que exista ese registro
                try {
                    Parte regVerificado = pfl.find(reg.getIdParte());
                    if (regVerificado != null) {
                        if (pfl.edit(reg)) {
                            return pfl.find(reg.getIdParte());
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