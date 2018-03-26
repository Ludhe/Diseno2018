/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Parte;

/**
 *
 * @author rcarlos
 */
@Local
public interface ParteFacadeLocal {

    void create(Parte parte);

    void edit(Parte parte);

    void remove(Parte parte);

    Parte find(Object id);

    List<Parte> findAll();

    List<Parte> findRange(int[] range);

    int count();
    
}
