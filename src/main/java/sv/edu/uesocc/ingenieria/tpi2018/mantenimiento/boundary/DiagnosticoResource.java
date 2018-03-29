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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.DiagnosticoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Diagnostico;

/**
 *
 * @author dmmaga
 */
@Path("diagnostico")
public class DiagnosticoResource implements Serializable {

    @EJB
    private DiagnosticoFacadeLocal dfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Diagnostico> findAll() {
        if (dfl != null) {
            List<Diagnostico> list = new ArrayList<>();
            try {
                list = dfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Diagnostico> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (dfl != null) {
            try {
                List<Diagnostico> list = null;
                list = dfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{iddiagnostico}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Diagnostico findById(
            @PathParam("iddiagnostico") Integer id
    ) {
        if (dfl != null) {
            Diagnostico reg = null;
            try {
                reg = dfl.find(id);
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
        if (dfl != null) {
            try {
                return dfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Diagnostico delete(
            @PathParam("id") Integer id
    ) {
        if (dfl != null) {
            try {
                Diagnostico reg = dfl.find(id);
                if (reg != null) {
                    dfl.remove(reg);
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Diagnostico create(Diagnostico registro) {
        if (registro != null && registro.getIdDiagnostico() == null) {
            try {
                if (dfl != null) {
                    Diagnostico reg = dfl.crear(registro);
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
    public Diagnostico edit(Diagnostico reg) {
        if (dfl != null) {
            if (reg.getIdDiagnostico() != null) {
                //Verificar que exista ese registro
                try {
                    Diagnostico regVerificado = dfl.find(reg.getIdDiagnostico());
                    if (regVerificado != null) {
                        if (dfl.edit(reg)) {
                            return dfl.find(reg.getIdDiagnostico());
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
