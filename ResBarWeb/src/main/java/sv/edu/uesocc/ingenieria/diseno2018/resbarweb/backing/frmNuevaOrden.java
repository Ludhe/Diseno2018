/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.edu.diseno.acceso.ManejadorCategorias;
import sv.edu.diseno.acceso.ManejadorOrden;
import sv.edu.diseno.definiciones.Categoria;
import sv.edu.diseno.definiciones.DetalleOrden;
import sv.edu.diseno.definiciones.Orden;
import sv.edu.diseno.definiciones.Producto;
import sv.edu.diseno.excepciones.ErrorAplicacion;
import sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket.NuevoTicket;

/**
 *
 * @author dmmaga
 */
@ManagedBean
@ViewScoped
public class frmNuevaOrden implements Serializable {

    ManejadorOrden manejadorOrden;
    ManejadorCategorias manejadorCategorias;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;
    private Orden nuevaOrden;
    private List<Producto> productList;
    private Producto selectedProducto;

    private MenuModel model;

    public Orden getNuevaOrden() {
        return nuevaOrden;
    }

    public void setNuevaOrden(Orden nuevaOrden) {
        this.nuevaOrden = nuevaOrden;
    }

    public List<Producto> getProductList() {
        return productList;
    }

    public void setProductList(List<Producto> productList) {
        this.productList = productList;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    //GETTERS Y SETTERS DEL PRODUCTO
    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    //GETTERS Y SETTERS DEL MODELO
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    @PostConstruct
    public void init() {
        categorias = new ArrayList<>();
        categorias = manejadorCategorias.Obtener(true);
        selectedProducto = new Producto();
        model = new DefaultMenuModel();
        nuevaOrden = new Orden();
        nuevaOrden.idOrden = ManejadorOrden.ObtenerId();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        for (Categoria categoria : categorias) {
            DefaultMenuItem item = new DefaultMenuItem(categoria.getNombre());
            item.setCommand("#{frmDashboard.selectCategoria(" + categoria.getIdCategoria() + ")}");
            item.setUpdate("productosTabla");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

    //para hacer pasar a agregar productos
    public void productos() {
        if ((!nuevaOrden.cliente.isEmpty()) || (!nuevaOrden.mesa.isEmpty()) || (!nuevaOrden.mesero.isEmpty())) {
            System.out.println("LLEGUE CON ALGUNO NO VACIO");
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('addProductos').show();");
        }

    }

    public void addProductos() {
        RequestContext context = RequestContext.getCurrentInstance();
        //no ponerlo vacio --->  nuevaOrden.detalleOrdenList = productos; 
        context.execute("PF('addProductos').hide();");
    }

    public void cancelar() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('addProductos').hide();");
    }

    //para crear la orden
    public void guardar() {
        try {
            nuevaOrden.activa = true;
            nuevaOrden.CalcularTotal();
            ManejadorOrden.Insertar(nuevaOrden);
            //si se crea la nueva orden se imprimen los tickets automaticos
            // ticket.TicketBebida(nuevaOrden);
            // ticket.TicketCocina(nuevaOrden);
        } catch (Exception e) {

        }
    }

}
