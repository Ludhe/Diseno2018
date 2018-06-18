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
import sv.edu.diseno.acceso.ManejadorProductos;
import sv.edu.diseno.definiciones.Categoria;
import sv.edu.diseno.definiciones.Producto;

/**
 *
 * @author dmmaga
 */
@ManagedBean(name = "administrar")
@ViewScoped
public class frmAdministrar implements Serializable {

    //Manejador Categorías
    ManejadorCategorias manejadorCategorias;
    ManejadorProductos manejadorProductos;
    private List<Categoria> categorias;
    private List<Producto> productos;
    private Producto producto = new Producto();
    private Producto selectedProduct = new Producto();
    private Categoria categoria = new Categoria();
    private Categoria selectedCategoria = new Categoria();
    //Para generar el menu con categorías
    private MenuModel model;
    final static boolean sub = false;

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }

    public Producto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Producto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        //
        return ManejadorCategorias.Obtener(sub);
    }

    @PostConstruct
    public void init() {
        productos = new ArrayList<>();
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        List<Categoria> cat = getCategorias();
        categoria = cat.get(0);
        setProductos(ManejadorProductos.ObtenerxCategoria(categoria.idCategoria));
        for (int i = 0; i < cat.size(); i++) {
            DefaultMenuItem item = new DefaultMenuItem(cat.get(i).nombre);
            item.setIcon("ui-icon-arrowthick-1-e");
            //item.setCommand("#{administrar.setIdCategoria("+i+")}");
            item.setCommand("#{administrar.recargarProductos(" + i + ")}");
            item.setUpdate(":form:productos :modales");
            item.setAjax(true);
            firstSubmenu.addElement(item);
        }

        model.addElement(firstSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public void recargarProductos(String id) {
        List<Categoria> cat = getCategorias();
        Categoria seleccionada = cat.get(Integer.parseInt(id));
        setCategoria(seleccionada);
        int idSeleccionada = seleccionada.idCategoria;
        setProductos(ManejadorProductos.ObtenerxCategoria(idSeleccionada));
    }

    public void agregarProducto() {
        producto.setIdCategoria(categoria);
        int idProd = ManejadorProductos.ObtenerId();
        producto.idProducto = idProd;
        ManejadorProductos.Insertar(producto);
        recargarProductos("0");

    }

    public void eliminarProducto() {
        if (producto != null) {
            ManejadorProductos.Eliminar(producto);
            recargarProductos("0");
        }
    }

    public void agregarCategoria() {
        if (categoria != null) {
            categoria.idCategoria = ManejadorCategorias.ObtenerId();
            ManejadorCategorias.Insertar(categoria);
        }

    }

     public void eliminarCategoria() {
        if (categoria != null) {
            List<Producto> list = categoria.getProductoList();
            for (Producto prod : list) {
                ManejadorProductos.Eliminar(prod);
            }
            ManejadorCategorias.Eliminar(categoria);
            recargarProductos("0");
        }
    }
    
    public void modificarProducto(){
            ManejadorProductos.Actualizar(selectedProduct);
            recargarProductos("0");
    }
    
    public void modificarCategoria(){
            ManejadorCategorias.Actualizar(selectedCategoria);
    }
}
