/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoResponsable;

/**
 *
 * @author rcarlos
 */
@Local
public interface TipoResponsableFacadeLocal {

    void create(TipoResponsable tipoResponsable);

    void edit(TipoResponsable tipoResponsable);

    void remove(TipoResponsable tipoResponsable);

    TipoResponsable find(Object id);

    List<TipoResponsable> findAll();

    List<TipoResponsable> findRange(int[] range);

    int count();
    
}
