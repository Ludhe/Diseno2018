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
import sv.edu.diseno.excepciones.ErrorAplicacion;

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
    private Date fecha1;
    private Date fecha2;
    String fechaSeleccionada;

    public void onDateSelect(SelectEvent event) throws ParseException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", dateFormat.format(event.getObject())));
        fechaSeleccionada = dateFormat.format(event.getObject());
        fecha1 = dateFormat.parse(fechaSeleccionada);
        System.out.println("FECHA1=" + fecha1);
        fecha2 = dateFormat.parse(fechaSeleccionada);
        fecha2.setHours(23);
        fecha2.setMinutes(59);
        fecha2.setSeconds(59);
        System.out.println("fecha2=" + fecha2);
        historico = manejadorOrden.ObtenerVentas(fecha1, fecha2);
        System.out.println(historico);
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public List<Orden> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Orden> historico) {
        this.historico = historico;
    }

}
