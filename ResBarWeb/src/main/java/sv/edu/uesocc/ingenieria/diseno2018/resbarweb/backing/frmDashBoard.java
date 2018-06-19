/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;

@ManagedBean(name = "frmDashboard")
@ViewScoped
public class frmDashBoard implements Serializable {

    ManejadorOrden manejadorOrden;
    private List<Orden> ordenes;
    private Orden selectedOrden;
    private DetalleOrden selectedDetalleOrden;

    
    //Metodos De la Importantes del FRM
    @PostConstruct
    public void init() {
        ordenes = new ArrayList<>();
        ordenes = manejadorOrden.ObtenerActivas();
        
    }
    
    public void saveOrden(){
        manejadorOrden.Actualizar(selectedOrden);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('modificarOrdenDialog').hide();");        
    }
    
    public void logDatos(){
        System.out.println("Manejador: "+manejadorOrden);
        System.out.println("ordenes: "+ordenes);
        System.out.println("selectedOrden: "+selectedOrden);
    }
    
    
    //GETTERS Y SETTERS
    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Orden getSelectedOrden() {
        return selectedOrden;
    }

    public void setSelectedOrden(Orden selectedOrden) {
        this.selectedOrden = selectedOrden;
    }
    
    public DetalleOrden getSelectedDetalleOrden() {
        return selectedDetalleOrden;
    }

    public void setSelectedDetalleOrden(DetalleOrden selectedDetalleOrden) {
        this.selectedDetalleOrden = selectedDetalleOrden;
    }

}
