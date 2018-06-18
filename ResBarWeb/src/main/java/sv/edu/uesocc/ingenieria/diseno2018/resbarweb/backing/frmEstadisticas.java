/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Orden;
/**
 *
 * @author andrea
 */
@ManagedBean(name = "frmEstadisticas")
@ViewScoped
public class frmEstadisticas implements Serializable {

    ManejadorOrden manejadorOrden;
    private List<Orden> historico;
    private Date date1;
    private Date date2;
    private Date date3;
    private Date fecha1;
    private Date fecha2;
    String fechaSeleccionada;
    String fechaSeleccionada1;
    String fechaSeleccionada2;
    private Orden selectedOrden;
    
    public void fechasSeleccionada1(SelectEvent event) throws ParseException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", dateFormat.format(event.getObject())));
        fechaSeleccionada1 = dateFormat.format(event.getObject());
        fecha1 = dateFormat.parse(fechaSeleccionada1);
        fecha2 = dateFormat.parse(fechaSeleccionada1);
        fecha2.setHours(23);
        fecha2.setMinutes(59);
        fecha2.setSeconds(59);
        historico = manejadorOrden.ObtenerVentas(fecha1, fecha2);
    }
    
     public void fechasSeleccionada2(SelectEvent event) throws ParseException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", dateFormat.format(event.getObject())));
        fechaSeleccionada2 = dateFormat.format(event.getObject());
        fecha1 = dateFormat.parse(fechaSeleccionada1);
        fecha2 = dateFormat.parse(fechaSeleccionada2);
        fecha2.setHours(23);
        fecha2.setMinutes(59);
        fecha2.setSeconds(59);
        historico = manejadorOrden.ObtenerVentas(fecha1, fecha2);
    }

     //ALL GETTERS AND SETTERS
    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }
     
    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public List<Orden> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Orden> historico) {
        this.historico = historico;
    }

    public Orden getSelectedOrden() {
        return selectedOrden;
    }

    public void setSelectedOrden(Orden selectedOrden) {
        this.selectedOrden = selectedOrden;
    }
    
}
