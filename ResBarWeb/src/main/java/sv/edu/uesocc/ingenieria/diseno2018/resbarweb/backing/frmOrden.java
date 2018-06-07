 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sv.edu.diseno.definiciones.Orden;

 
@ManagedBean(name="dtBasicView")
@ViewScoped
public class frmOrden implements Serializable {
     
    private List<Orden> cars;
     
    @ManagedProperty("#{ordenService}")
    private OrdenService service;
 
    @PostConstruct
    public void init() {
        cars = service.createOrdens(10);
    }
     
    public List<Orden> getOrdens() {
        return cars;
    }
 
    public void setService(OrdenService service) {
        this.service = service;
    }
}