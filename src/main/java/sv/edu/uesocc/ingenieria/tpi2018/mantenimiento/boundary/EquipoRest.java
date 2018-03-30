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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.EquipoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Equipo;

/**
 *
 * @author jcpleitez
 */
@Path("equipo")
public class EquipoRest implements Serializable {
    
    @EJB
    private EquipoFacadeLocal efl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Equipo> findAll() {
        if (efl != null) {
            try {
                List<Equipo> list = null;                
                list = efl.findAll();
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
    public List<Equipo> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (efl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = efl.findRange(first, pageSize);
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
        if (efl != null) {
            try {
                return efl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Equipo findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        if (efl != null && id != null && id > 0) {
            try {
                Equipo reg = efl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new Equipo();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Equipo create(Equipo registro) {
        if (efl != null && registro != null) {
            try {
                Equipo r = efl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new Equipo();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Equipo edit(Equipo registro) {
        if (efl != null) {
            if (registro != null && registro.getIdQuipo()!= null) {
                try {
                    Equipo r = efl.editar(registro);
                    if (r != null && r.getIdQuipo() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new Equipo();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Equipo delete(
            @PathParam("id") Integer id
    ) {
        if (efl != null && id != null && id > 0) {
            try {
                Equipo reg = efl.find(id);
                if(reg != null){
                    if (efl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Equipo();
    }
    
}
