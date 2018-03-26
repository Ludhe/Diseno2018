/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.MantenimientoDetalle;

/**
 *
 * @author rcarlos
 */
@Stateless
public class MantenimientoDetalleFacade extends AbstractFacade<MantenimientoDetalle> implements MantenimientoDetalleFacadeLocal {

    @PersistenceContext(unitName = "mantenimiento-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MantenimientoDetalleFacade() {
        super(MantenimientoDetalle.class);
    }
    
}
