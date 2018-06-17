/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.edu.diseno.acceso.ManejadorCategorias;
import sv.edu.diseno.definiciones.Categoria;
import sv.edu.diseno.definiciones.Producto;

/**
 *
 * @author doratt
 */
@ManagedBean(name = "dtMenu")
@ViewScoped
public class frmMenu {

    private List<Categoria> categorias;

  // @ManagedProperty("#{categoriaService}")
   // private CategoriaService service;
    private MenuModel model;
    private List<Producto> productos;

    @PostConstruct
    public void init() {
        categorias = ManejadorCategorias.Obtener(false);
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Categorias");
        for (Categoria categoria : categorias) {
            DefaultMenuItem item = new DefaultMenuItem(categoria.nombre);
            item.setIcon("ui-icon-circle-arrow-e");
            firstSubmenu.addElement(item);
            System.out.println(item.getId());
        }
        model.addElement(firstSubmenu);
    }
    
    
    public void actualizarProductos(SelectItem event){
        System.out.println(event.getValue());
    }

    public List<Producto> getProductos(){
        return productos;
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public MenuModel getModel() {
        return model;
    }

//    public void setService(CategoriaService service) {
//        this.service = service;
//    }
//
//    public CategoriaService getService() {
//        return service;
//    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    

}
