/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.edu.diseno.acceso.ManejadorCategorias;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Categoria;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.DetalleOrdenPK;
import sv.edu.diseno.definiciones.Orden;
import sv.edu.diseno.definiciones.Producto;
import sv.edu.diseno.excepciones.ErrorAplicacion;
import sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket.NuevoTicket;

@ManagedBean(name = "frmDashboard")
@ViewScoped
public class frmDashBoard implements Serializable {

    ManejadorOrden manejadorOrden;
    private List<Orden> ordenes;
    private Orden selectedOrden;
    private List<DetalleOrden> detalleOrden;
    ManejadorCategorias manejadorCategorias;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;
    private Producto selectedProducto;
    private int cantidadSelectedProducto = 1;
    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        categorias = manejadorCategorias.Obtener(true);
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        for (int i = 0; i < categorias.size(); i++) {
            DefaultMenuItem item = new DefaultMenuItem(categorias.get(i).nombre);
            item.setIcon("ui-icon-arrowthick-1-e");
            //item.setCommand("#{administrar.setIdCategoria("+i+")}");
            item.setCommand("#{frmDashboard.generarSelectedCateogia(" + categorias.get(i).getIdCategoria() + ")}");
            item.setUpdate(":form:agregarProductosPanel");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

    public void generarSelectedCateogia(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (idCategoria == categoria.getIdCategoria()) {
                selectedCategoria = categoria;
                break;
            }
        }
    }

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

    public void saveDetalleOrden() {
        RequestContext context = RequestContext.getCurrentInstance();
        //FacesContext context2 = FacesContext.getCurrentInstance();
        boolean exits = false;
        for (DetalleOrden detOrd : selectedOrden.getDetalleOrdenList()) {
            if (detOrd.getProducto().idProducto.equals(selectedProducto.idProducto)) {
                exits = true;
                break;
            }
        }
        if (exits) {//Sumarle la cantidad de productos
            System.out.println("Existe");
            List<DetalleOrden> l = selectedOrden.getDetalleOrdenList();
            for (DetalleOrden detOrd : l) {
                if (detOrd.getProducto().idProducto.equals(selectedProducto.idProducto)) {
                    //BigDecimal v = BigDecimal.valueOf(cantidadSelectedProducto+Integer.parseInt(detOrd.getCantidad()+""));
                    int v = cantidadSelectedProducto + detOrd.getCantidad().intValue();
                    double vd = (double) v;
                    System.out.println("Nueva Cantidad = "+v);
                    detOrd.setCantidad(new BigDecimal(vd));
                    break;
                }
            }
            selectedOrden.setDetalleOrdenList(l);
            manejadorOrden.Actualizar(selectedOrden);
        } else {//Crear el Detalle de la Orden
            System.out.println("Agregar");
            DetalleOrdenPK detOrdPri = new DetalleOrdenPK(selectedOrden.idOrden, selectedProducto.idProducto);            
            DetalleOrden detOrd = new DetalleOrden(detOrdPri, new BigDecimal((double) cantidadSelectedProducto));
            detOrd.setProducto(selectedProducto);
            detOrd.setOrden(selectedOrden);
            selectedOrden.getDetalleOrdenList().add(detOrd);
            manejadorOrden.Actualizar(selectedOrden);
        }
        context.execute("PF('agregarProductoDialog').hide();");        
    }

    public MenuModel getModel() {
        return model;
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

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public int getCantidadSelectedProducto() {
        return cantidadSelectedProducto;
    }

    public void setCantidadSelectedProducto(int cantidadSelectedProducto) {
        this.cantidadSelectedProducto = cantidadSelectedProducto;
    }

}
