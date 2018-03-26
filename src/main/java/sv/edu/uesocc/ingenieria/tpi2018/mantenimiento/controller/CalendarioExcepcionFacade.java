/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.CalendarioExcepcion;

/**
 *
 * @author rcarlos
 */
@Stateless
public class CalendarioExcepcionFacade extends AbstractFacade<CalendarioExcepcion> implements CalendarioExcepcionFacadeLocal {

    @PersistenceContext(unitName = "mantenimiento-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendarioExcepcionFacade() {
        super(CalendarioExcepcion.class);
    }
    
}
