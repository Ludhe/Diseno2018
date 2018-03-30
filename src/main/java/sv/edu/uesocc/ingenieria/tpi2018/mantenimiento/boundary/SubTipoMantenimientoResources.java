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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.SubTipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.SubTipoMantenimiento;

/**
 *
 * @author dmmaga
 */
@Path("subtipomtto")
public class SubTipoMantenimientoResources implements Serializable {
    
    @EJB
    private SubTipoMantenimientoFacadeLocal stmfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<SubTipoMantenimiento> findAll() {
        if (stmfl != null) {
            try {
                List<SubTipoMantenimiento> list;
                list = stmfl.findAll();
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<SubTipoMantenimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (stmfl != null) {
            try {
                List<SubTipoMantenimiento> list;
                list = stmfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }
    
    @GET
    @Path("{idsubtipomtto}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento findById(
            @PathParam("idsubtipomtto") Integer id
    ) {
        if (stmfl != null) {
            SubTipoMantenimiento reg;
            try {
                if (id != null) {
                    reg = stmfl.find(id);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {
        if (stmfl != null) {
            try {
                return stmfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return 0;
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento delete(
            @PathParam("id") Integer id
    ) {
        if (stmfl != null) {
            try {
                SubTipoMantenimiento reg = stmfl.find(id);
                if (reg != null) {
                    stmfl.remove(reg);
                    return reg;
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new SubTipoMantenimiento();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento create(SubTipoMantenimiento registro) {
        if (registro != null && registro.getIdSubTipoMantenimiento() == null) {
            try {
                if (stmfl != null) {
                    SubTipoMantenimiento reg = stmfl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new SubTipoMantenimiento();
    }
    
    @PUT    
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public SubTipoMantenimiento edit(SubTipoMantenimiento reg) {        
        if (stmfl != null) {
            if (reg.getIdSubTipoMantenimiento() != null) {
                //Verificar que exista ese registro
                try {
                    SubTipoMantenimiento regVerificado = stmfl.find(reg.getIdSubTipoMantenimiento());
                    if (regVerificado != null) {
                        if (stmfl.edit(reg)) {
                            return stmfl.find(reg.getIdSubTipoMantenimiento());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return new SubTipoMantenimiento();
    }
}
