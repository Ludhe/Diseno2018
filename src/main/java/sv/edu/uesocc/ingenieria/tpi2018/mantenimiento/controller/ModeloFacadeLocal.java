/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Modelo;

/**
 *
 * @author rcarlos
 */
@Local
public interface ModeloFacadeLocal {

    void create(Modelo modelo);

    void edit(Modelo modelo);

    void remove(Modelo modelo);

    Modelo find(Object id);

    List<Modelo> findAll();

    List<Modelo> findRange(int[] range);

    int count();
    
}
