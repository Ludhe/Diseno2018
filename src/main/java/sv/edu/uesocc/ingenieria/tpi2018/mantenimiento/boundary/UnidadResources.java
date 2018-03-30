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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.UnidadFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Unidad;

/**
 *
 * @author dmmaga
 */
@Path("unidad")
public class UnidadResources implements Serializable {

    @EJB
    private UnidadFacadeLocal ufl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Unidad> findAll() {
        if (ufl != null) {
            try {
                List<Unidad> list;
                list = ufl.findAll();
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Unidad> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (ufl != null) {
            try {
                List<Unidad> list;
                list = ufl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Path("{idunidad}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad findById(
            @PathParam("idunidad") Integer id
    ) {
        if (ufl != null) {
            Unidad reg;
            try {
                if (id != null && id > 0) {
                    reg = ufl.find(id);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Unidad();
    }

    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (ufl != null) {
            try {
                return ufl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return 0;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad delete(
            @PathParam("id") Integer id
    ) {
        if (ufl != null) {
            try {
                Unidad reg = ufl.find(id);
                if (reg != null) {
                    ufl.remove(reg);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Unidad();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad create(Unidad registro) {
        if (registro != null && registro.getIdUnidad() == null) {
            try {
                if (ufl != null) {
                    Unidad reg = ufl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Unidad();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Unidad edit(Unidad reg) {
        if (ufl != null) {
            if (reg.getIdUnidad() != null) {
                //Verificar que exista ese registro
                try {
                    Unidad regVerificado = ufl.find(reg.getIdUnidad());
                    if (regVerificado != null) {
                        if (ufl.edit(reg)) {
                            return ufl.find(reg.getIdUnidad());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return new Unidad();
    }

}
