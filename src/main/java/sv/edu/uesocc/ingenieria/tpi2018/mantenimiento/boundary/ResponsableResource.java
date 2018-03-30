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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.ResponsableFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Responsable;

/**
 *
 * @author dmmaga
 */
@Path("responsable")
public class ResponsableResource implements Serializable {

    @EJB
    private ResponsableFacadeLocal rfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Responsable> findAll() {
        if (rfl != null) {
            try {
                List<Responsable> list;
                list = rfl.findAll();
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Responsable> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (rfl != null) {
            try {
                List<Responsable> list;
                list = rfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Path("{idresponsable}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Responsable findById(
            @PathParam("idresponsable") Integer id
    ) {
        if (rfl != null) {
            Responsable reg;
            try {
                if (id != null && id > 0) {
                    reg = rfl.find(id);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Responsable();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (rfl != null) {
            try {
                return rfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return 0;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Responsable delete(
            @PathParam("id") Integer id
    ) {
        if (rfl != null) {
            try {
                Responsable reg = rfl.find(id);
                if (reg != null) {
                    rfl.remove(reg);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Responsable();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Responsable create(Responsable registro) {
        if (registro != null && registro.getIdResponsable() == null) {
            try {
                if (rfl != null) {
                    Responsable reg = rfl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Responsable();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Responsable edit(Responsable reg) {
        if (rfl != null) {
            if (reg.getIdResponsable() != null) {
                //Verificar que exista ese registro
                try {
                    Responsable regVerificado = rfl.find(reg.getIdResponsable());
                    if (regVerificado != null) {
                        if (rfl.edit(reg)) {
                            return rfl.find(reg.getIdResponsable());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return new Responsable();
    }

}
