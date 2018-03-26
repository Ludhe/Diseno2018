/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.TipoParte;

/**
 *
 * @author rcarlos
 */
@Local
public interface TipoParteFacadeLocal {

    void create(TipoParte tipoParte);

    void edit(TipoParte tipoParte);

    void remove(TipoParte tipoParte);

    TipoParte find(Object id);

    List<TipoParte> findAll();

    List<TipoParte> findRange(int[] range);

    int count();
    
}
