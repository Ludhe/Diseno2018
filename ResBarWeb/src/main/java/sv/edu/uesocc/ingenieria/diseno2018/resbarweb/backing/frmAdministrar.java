/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
      //Para generar el menu con categorías
    private MenuModel model;
  
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
        boolean sub = false;
        return manejadorCategorias.Obtener(sub);
    }
    
    

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        List<Categoria> cat = getCategorias();
        for (int i = 0; i < cat.size(); i++) {
            DefaultMenuItem item = new DefaultMenuItem(cat.get(i).nombre);
            item.setIcon("ui-icon-arrowthick-1-e");
            //item.setCommand("#{administrar.setIdCategoria("+i+")}");
            item.setCommand("#{administrar.imprimir("+i+")}");
            item.setUpdate("form");
            item.setAjax(false);
            firstSubmenu.addElement(item);
        }

        model.addElement(firstSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }
    

    public void imprimir(String id){
        List<Categoria> cat = getCategorias();
        Categoria seleccionada = cat.get(Integer.parseInt(id));
        int idSeleccionada = seleccionada.idCategoria;
        setProductos(manejadorProductos.ObtenerxCategoria(idSeleccionada));
        System.out.println(getProductos());
    }
    
    public void saludarDiana(){
        System.out.println("Hola Diana :D si te dormis te mato:3");
    }
    
}
