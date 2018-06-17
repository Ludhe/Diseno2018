/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

/**
 *
 * @author doratt
 */
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.edu.diseno.acceso.ManejadorCategorias;
import sv.edu.diseno.definiciones.Categoria;
import sv.edu.diseno.definiciones.Producto;
 
@ManagedBean(name = "dtMenuView")
@ViewScoped
public class MenuView {
     
    private MenuModel model;
    private LazyDataModel<Producto> modelo;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
        List<Categoria> Categorias = ManejadorCategorias.Obtener(false);
        for (Categoria categoria : Categorias) {
             DefaultMenuItem item = new DefaultMenuItem(categoria);
        item.setIcon("ui-icon-circle-arrow-e");
        firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
         
    }
 
    public MenuModel getModel() {
        return model;
    }   

    public LazyDataModel getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel modelo) {
        this.modelo = modelo;
    }
    
     
     
     
     
}
