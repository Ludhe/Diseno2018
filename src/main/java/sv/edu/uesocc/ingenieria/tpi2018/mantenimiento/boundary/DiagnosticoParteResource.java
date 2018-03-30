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
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.DiagnosticoParteFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.DiagnosticoParte;

/**
 *
 * @author dmmaga
 */
@Path("diagnosticoparte")
public class DiagnosticoParteResource implements Serializable {

    @EJB
    private DiagnosticoParteFacadeLocal dpfl;

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<DiagnosticoParte> findAll() {
        if (dpfl != null) {
            try {
                List<DiagnosticoParte> list = null;                
                list = dpfl.findAll();
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
    public List<DiagnosticoParte> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (dpfl != null && first >= 0 && pageSize >= 0) {
            try {
                List salida = null;
                salida = dpfl.findRange(first, pageSize);
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
        if (dpfl != null) {
            try {
                return dpfl.count();                
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return 0;
    }

    @GET
    @Path("{idcalendarioexcepcion}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte findById(
            @PathParam("idcalendarioexcepcion") Integer id
    ) {
        if (dpfl != null && id != null && id > 0) {
            try {
                DiagnosticoParte reg = dpfl.find(id);
                if (reg != null) {
                    return reg;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return new DiagnosticoParte();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte create(DiagnosticoParte registro) {
        if (dpfl != null && registro != null) {
            try {
                DiagnosticoParte r = dpfl.crear(registro);
                if (r != null) {
                    return r;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }            
        }
        return new DiagnosticoParte();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte edit(DiagnosticoParte registro) {
        if (dpfl != null) {
            if (registro != null && registro.getIdDiagnosticoParte()!= null) {
                try {
                    DiagnosticoParte r = dpfl.editar(registro);
                    if (r != null && r.getIdDiagnosticoParte() != null) {
                        return r;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return new DiagnosticoParte();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte delete(
            @PathParam("id") Integer id
    ) {
        if (dpfl != null && id != null && id > 0) {
            try {
                DiagnosticoParte reg = dpfl.find(id);
                if(reg != null){
                    if (dpfl.remove(reg)) {
                        return reg;
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return new DiagnosticoParte();
    }

}