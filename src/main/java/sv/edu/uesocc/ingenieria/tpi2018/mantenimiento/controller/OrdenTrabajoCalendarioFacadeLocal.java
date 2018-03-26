/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.OrdenTrabajoCalendario;

/**
 *
 * @author rcarlos
 */
@Local
public interface OrdenTrabajoCalendarioFacadeLocal {

    void create(OrdenTrabajoCalendario ordenTrabajoCalendario);

    void edit(OrdenTrabajoCalendario ordenTrabajoCalendario);

    void remove(OrdenTrabajoCalendario ordenTrabajoCalendario);

    OrdenTrabajoCalendario find(Object id);

    List<OrdenTrabajoCalendario> findAll();

    List<OrdenTrabajoCalendario> findRange(int[] range);

    int count();
    
}
