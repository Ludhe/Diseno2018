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
import sv.edu.diseno.definiciones.Categoria;

/**
 *
 * @author dmmaga
 */
@ManagedBean(name = "administrar")
@ViewScoped
public class frmAdministrar implements Serializable {
    
    int idCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    //Manejador Categorías
    ManejadorCategorias manejadorCategorias;
    private List<Categoria> categorias;

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return manejadorCategorias.Obtener(false);
    }
    
    //Para generar el menu con categorías
    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        List<Categoria> cat = getCategorias();
        for (int i = 0; i < cat.size(); i++) {
            DefaultMenuItem item = new DefaultMenuItem(cat.get(i).nombre);
            item.setIcon("ui-icon-arrowthick-1-e");
            //item.setCommand("#{administrar.setIdCategoria("+i+")}");
            item.setOnclick("#{administrar.imprimir}");
            firstSubmenu.addElement(item);
        }

        model.addElement(firstSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }
    

    public void imprimir(){
        System.out.println("holaaaaaa");
    }
    
}
