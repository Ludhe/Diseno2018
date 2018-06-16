 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Orden;

 
@ManagedBean(name="dtBasicView")
@ViewScoped
public class frmOrden implements Serializable {
     
    ManejadorOrden manejadorOrden;
    private List<Orden> ordenes;

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    
    public List<Orden> getOrdenes() {
        return manejadorOrden.ObtenerActivas();
    }
    
}