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
            List<DiagnosticoParte> list = new ArrayList<>();
            try {
                list = dpfl.findAll();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            return list;
        }
        return null;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<DiagnosticoParte> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {        
        if (dpfl != null) {
            try {
                List<DiagnosticoParte> list = null;
                list = dpfl.findRange(first, pageSize);
                return list;
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @GET
    @Path("{iddiagnosticoparte}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte findById(
            @PathParam("iddiagnosticoparte") Integer id
    ) {
        if (dpfl != null) {
            DiagnosticoParte reg = null;
            try {
                reg = dpfl.find(id);
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
        if (dpfl != null) {
            try {
                return dpfl.count();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public DiagnosticoParte delete(
            @PathParam("id") Integer id
    ) {
        if (dpfl != null) {
            try {
                DiagnosticoParte reg = dpfl.find(id);
                if(reg != null){
                    dpfl.remove(reg);
                }                
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+"; charset=utf-8"})
    public DiagnosticoParte create(DiagnosticoParte registro){
        if (registro != null && registro.getIdDiagnosticoParte()== null) {
            try {
                if (dpfl != null) {
                    DiagnosticoParte reg = dpfl.crear(registro);
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
    public DiagnosticoParte edit(DiagnosticoParte reg) {        
        if (dpfl != null) {
            if (reg.getIdDiagnosticoParte()!= null) {
                //Verificar que exista ese registro
                try {
                    DiagnosticoParte regVerificado = dpfl.find(reg.getIdDiagnosticoParte());
                    if (regVerificado != null) {
                        if (dpfl.edit(reg)) {
                            return dpfl.find(reg.getIdDiagnosticoParte());
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