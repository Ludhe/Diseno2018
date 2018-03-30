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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.CalendarioFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Calendario;

/**
 *
 * @author dmmaga
 */
@Path("calendario")
public class CalendarioResources implements Serializable {

    @EJB
    private CalendarioFacadeLocal calendarioFacade;

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario create(Calendario registro) {
        if (calendarioFacade != null && registro != null) {
            try {
                Calendario r = calendarioFacade.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new Calendario();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario edit(Calendario registro) {
        if (calendarioFacade != null) {
            if (registro != null && registro.getIdFecha() != null) {
                try {
                    Calendario r = calendarioFacade.editar(registro);
                    if (r != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new Calendario();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario delete(
            @PathParam("id") Integer id
    ) {
        if (calendarioFacade != null && id != null && id > 0) {
            try {
                Calendario reg = calendarioFacade.find(id);
                if(reg != null){
                    if (calendarioFacade.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Calendario();
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Calendario> findAll() {
        if (calendarioFacade != null) {
            try {
                List<Calendario> list = null;                
                list = calendarioFacade.findAll();
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
    public List<Calendario> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (calendarioFacade != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = calendarioFacade.findRange(first, pageSize);
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
        if (calendarioFacade != null) {
            try {
                return calendarioFacade.count();
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idfecha}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Calendario findById(
            @PathParam("idfecha") Integer id
    ) {
        if (calendarioFacade != null && id != null && id > 0) {
            try {
                Calendario reg = calendarioFacade.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Calendario();
    }

}
