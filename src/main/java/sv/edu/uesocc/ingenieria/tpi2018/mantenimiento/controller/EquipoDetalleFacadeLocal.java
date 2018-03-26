/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.EquipoDetalle;

/**
 *
 * @author rcarlos
 */
@Local
public interface EquipoDetalleFacadeLocal {

    void create(EquipoDetalle equipoDetalle);

    void edit(EquipoDetalle equipoDetalle);

    void remove(EquipoDetalle equipoDetalle);

    EquipoDetalle find(Object id);

    List<EquipoDetalle> findAll();

    List<EquipoDetalle> findRange(int[] range);

    int count();
    
}
