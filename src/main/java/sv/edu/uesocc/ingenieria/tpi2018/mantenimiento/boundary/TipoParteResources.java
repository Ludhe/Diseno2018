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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.TipoParteFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoParte;

/**
 *
 * @author dmmaga
 */
@Path("tipoparte")
public class TipoParteResources implements Serializable {

    @EJB
    private TipoParteFacadeLocal tpfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoParte> findAll() {
        if (tpfl != null) {
            List<TipoParte> list = new ArrayList<>();
            try {
                list = tpfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<TipoParte> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (tpfl != null) {
            try {
                List<TipoParte> list = null;
                list = tpfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{idtipoparte}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoParte findById(
            @PathParam("idtipoparte") Integer id
    ) {
        if (tpfl != null) {
            TipoParte reg = null;
            try {
                reg = tpfl.find(id);
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
        if (tpfl != null) {
            try {
                return tpfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public TipoParte delete(
            @PathParam("id") Integer id
    ) {
        if (tpfl != null) {
            try {
                TipoParte reg = tpfl.find(id);
                if(reg != null){
                    tpfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public TipoParte create(TipoParte registro){
        if (registro != null && registro.getIdTipoParte()== null) {
            try {
                if (tpfl != null) {
                    TipoParte reg = tpfl.crear(registro);
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
    public TipoParte edit(TipoParte reg) {        
        if (tpfl != null) {
            if (reg.getIdTipoParte() != null) {
                //Verificar que exista ese registro
                try {
                    TipoParte regVerificado = tpfl.find(reg.getIdTipoParte());
                    if (regVerificado != null) {
                        if (tpfl.edit(reg)) {
                            return tpfl.find(reg.getIdTipoParte());
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
