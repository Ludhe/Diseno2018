/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;
import sv.edu.diseno.excepciones.ErrorAplicacion;

@ManagedBean(name = "frmDashboard")
@ViewScoped
public class frmDashBoard implements Serializable {

    ManejadorOrden manejadorOrden;    
    private List<Orden> ordenes;
    private Orden selectedOrden;
    private List<DetalleOrden> detalleOrden;

    
    public void saveOrden() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext context2 = FacesContext.getCurrentInstance();
        try {
            manejadorOrden.Actualizar(selectedOrden);
            context.execute("PF('modificarDialog').hide();");
            context2.addMessage(null, new FacesMessage("Successful", "Orden Modificada"));
        } catch (ErrorAplicacion e) {
            context2.addMessage(null, new FacesMessage("ERROR", "Orden Modificada"));
        }

    }

    //ALL GETTERS AND SETTERS
    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public List<Orden> getOrdenes() {
        return manejadorOrden.ObtenerActivas();
    }
    
    public void setSelectedOrden(Orden selectedOrden) {
        this.selectedOrden = selectedOrden;
    }

    public Orden getSelectedOrden() {
        return selectedOrden;
    }
    
    public List<DetalleOrden> getDetalleOrden() {
        return selectedOrden.getDetalleOrdenList();
    }

    public void setDetalleOrden(List<DetalleOrden> detalleOrden) {
        this.selectedOrden.setDetalleOrdenList(detalleOrden);
    }
    
    
}
