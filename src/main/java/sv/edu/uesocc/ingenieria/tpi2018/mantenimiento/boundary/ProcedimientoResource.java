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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.ProcedimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Procedimiento;

/**
 *
 * @author dmmaga
 */
@Path("procedimiento")
public class ProcedimientoResource implements Serializable {

    @EJB
    private ProcedimientoFacadeLocal pfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Procedimiento> findAll() {
        if (pfl != null) {
            try {
                List<Procedimiento> list;
                list = pfl.findAll();
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Procedimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (pfl != null) {
            try {
                List<Procedimiento> list;
                list = pfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new ArrayList();
    }

    @GET
    @Path("{idprocedimiento}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Procedimiento findById(
            @PathParam("idprocedimiento") Integer id
    ) {
        if (pfl != null) {
            Procedimiento reg;
            try {
                if (id != null) {
                    reg = pfl.find(id);
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
        if (pfl != null) {
            try {
                return pfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return 0;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Procedimiento delete(
            @PathParam("id") Integer id
    ) {
        if (pfl != null) {
            try {
                Procedimiento reg = pfl.find(id);
                if (reg != null) {
                    pfl.remove(reg);
                    return reg;
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Procedimiento();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Procedimiento create(Procedimiento registro) {
        if (registro != null && registro.getIdProcedimiento() == null) {
            try {
                if (pfl != null) {
                    Procedimiento reg = pfl.crear(registro);
                    if (reg != null) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new Procedimiento();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Procedimiento edit(Procedimiento reg) {
        if (pfl != null) {
            if (reg.getIdProcedimiento() != null) {
                //Verificar que exista ese registro
                try {
                    Procedimiento regVerificado = pfl.find(reg.getIdProcedimiento());
                    if (regVerificado != null) {
                        if (pfl.edit(reg)) {
                            return pfl.find(reg.getIdProcedimiento());
                        }
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
        return new Procedimiento();
    }

}
