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

@ManagedBean(name = "frmDashboard")
@ViewScoped
public class frmDashBoard implements Serializable {

    ManejadorOrden manejadorOrden;
    private List<Orden> ordenes;
    private Orden selectedOrden;
    private DetalleOrden selectedDetalleOrden;
    
    ManejadorCategorias manejadorCategorias;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;
    
    private Producto selectedProducto;

    private MenuModel model;

    
    //Metodos De la Importantes del FRM
    @PostConstruct
    public void init() {
        ordenes = new ArrayList<>();        
        ordenes = manejadorOrden.ObtenerActivas();
        
        categorias = new ArrayList<>();
        categorias = manejadorCategorias.Obtener(true);
        
        selectedOrden = new Orden();
        selectedProducto = new Producto();
        selectedDetalleOrden = new DetalleOrden();
        
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        for (Categoria categoria : categorias) {
            DefaultMenuItem item = new DefaultMenuItem(categoria.getNombre());
            item.setCommand("#{frmDashboard.selectCategoria("+categoria.getIdCategoria()+")}");
            item.setUpdate("productosTabla");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }
    
    public void saveOrden(){
        manejadorOrden.Actualizar(selectedOrden);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('modificarOrdenDialog').hide();");        
    }
    
    public void selectCategoria(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (idCategoria == categoria.getIdCategoria()) {
                selectedCategoria = categoria;
                break;
            }
        }
    }
    
    public void logDatos(){
        //System.out.println("Manejador: "+manejadorOrden);
        //System.out.println("ordenes: "+ordenes);
        //System.out.println("selectedOrden: "+selectedOrden);
        System.out.println("selectedProduct: "+selectedProducto);
    }
    
    
    //GETTERS Y SETTERS DE ORDEN
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
    
    //GETTERS Y SETTERS DE CATEGORIOAS
    
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
    
}
