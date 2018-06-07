/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Orden;

 
@ManagedBean(name = "ordenService")
@ApplicationScoped
public class OrdenService {
    
    ManejadorOrden manejadorOrden;
     
    public List<Orden> createOrdens(int size) {
        List<Orden> list = manejadorOrden.ObtenerActivas();
        return list;
    }     
    
}
