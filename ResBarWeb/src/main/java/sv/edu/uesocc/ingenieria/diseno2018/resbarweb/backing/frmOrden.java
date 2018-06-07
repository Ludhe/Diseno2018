 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Orden;


@ManagedBean(name="dtSelectionView")
@ViewScoped
public class frmOrden implements Serializable {


    private LazyDataModel<Orden> modelo;
    private Orden registro;
    private String message;
    private boolean btnadd = true;
    private boolean textBox = true;
    private boolean botones = true;
    private boolean mostrandoDetalle = false;
    public ManejadorOrden mo;

    /**
     * Método para llenar la tabla con los modelos
     */
    @PostConstruct
    private void inicio() {
        registro = new Orden();
        try {
            this.modelo = new LazyDataModel<Orden>() {
                @Override
                public Object getRowKey(Orden object) {
                    if (object != null) {
                        return object.idOrden;
                    }
                    return null;
                }

                @Override
                public Orden getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = Integer.parseInt(rowKey);
                            for (Orden reg : (List<Orden>) getWrappedData()) {
                                if (reg.idOrden.compareTo(buscado) == 0) {
                                    return reg;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }

                @Override
                public List<Orden> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Orden> salida = new ArrayList();
                    try {
                        if (mo != null) {
                            this.setRowCount(mo.ObtenerActivas().size());
                            salida = mo.ObtenerActivas();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    /**
     * @param se SelectEvent
     * Método que recibe un evento para desplegar el formulario de Orden
     */
//    public void cambiarSeleccion(SelectEvent se) {
//        if (se.getObject() != null) {
//            try {
//                this.registro = (Orden) se.getObject();
//                Utils.id_modelo = String.valueOf(registro.getIdOrden());
//                this.mostrandoDetalle = true;
//                this.btnadd = true;
//            } catch (Exception e) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
//            }
//        }
//    }

    /**
     * Método que permite ingresar un nuevo registro y especifica funciones del botón nuevo
     */
    public void btnNuevo() {
        this.textBox = !this.textBox;
        this.registro = new Orden();
        this.btnadd = false;
        this.botones = true;
        this.mostrandoDetalle = !this.mostrandoDetalle;
    }
     
   
    /**
     * Método que elimina un modelo y especifica funciones del botón eliminar
     */
//    public void Eliminar() {
//        try {
//            if (this.registro != null && this.rfl != null) {
//                if (this.rfl.remove(registro)) {
//                    this.botones = !this.botones;
//                    this.btnadd = !this.btnadd;
//                    this.textBox = !this.textBox;
//                    this.registro = new Orden();
//                    setMessage(session.getMensaje("eliminar.bueno"));
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//            setMessage(session.getMensaje("eliminar.error"));
//        }
//    }

    /**
     * Método que edita un registro y especifica funciones del botón modificar
     */
//    public void Modificar() {
//        try {
//            if (this.registro != null && this.rfl != null) {
//                if (this.rfl.edit(registro)) {
//                    this.botones = !this.botones;
//                    this.btnadd = !this.btnadd;
//                    this.textBox = !this.textBox;
//                    setMessage(session.getMensaje("editar.bueno"));
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error " + e);
//            setMessage(session.getMensaje("editar.error"));
//        }
//    }

    /**
     * Método para habilitar botones y campos de texto
     */
    public void Habilitar() {
        this.botones = !this.botones;
        this.btnadd = !this.btnadd;
        this.textBox = !this.textBox;
    }

    /**
     * Método para mostrar el componente Message Growl
     */
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Info: ", message));
    }
    
    public void setMostrandoDetalle(boolean mostrandoDetalle) {
        this.mostrandoDetalle = mostrandoDetalle;
    }
    
    public void mostrarDetalles(){
        setMostrandoDetalle(true);
    } 

    public LazyDataModel<Orden> getOrden() {
        return modelo;
    }

    public void setOrden(LazyDataModel<Orden> modelo) {
        this.modelo = modelo;
    }

    public Orden getRegistro() {
        return registro;
    }

    public void setRegistro(Orden registro) {
        this.registro = registro;
    }

    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isTextBox() {
        return textBox;
    }

    public void setTextBox(boolean textBox) {
        this.textBox = textBox;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public boolean isMostrandoDetalle() {
        return mostrandoDetalle;
    }
}
