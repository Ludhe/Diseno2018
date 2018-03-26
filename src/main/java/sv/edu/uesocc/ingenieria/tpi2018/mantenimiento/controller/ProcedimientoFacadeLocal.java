/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Procedimiento;

/**
 *
 * @author rcarlos
 */
@Local
public interface ProcedimientoFacadeLocal {

    void create(Procedimiento procedimiento);

    void edit(Procedimiento procedimiento);

    void remove(Procedimiento procedimiento);

    Procedimiento find(Object id);

    List<Procedimiento> findAll();

    List<Procedimiento> findRange(int[] range);

    int count();
    
}
