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
import sv.edu.diseno.excepciones.ErrorAplicacion;
import sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket.NuevoTicket;

/**
 *
 * @author dmmaga
 */
@ManagedBean
@ViewScoped
public class frmNuevaOrden implements Serializable {

    //Instanciamos los manejadores
    ManejadorOrden manejadorOrden;
    private List<Categoria> categorias;
    ManejadorCategorias manejadorCategorias;
    private Orden nuevaOrden;
    Date fecha = new Date();
    List<DetalleOrden> productos = new ArrayList<>();
    private MenuModel model;
    NuevoTicket ticket = new NuevoTicket();

    //Para que se ejecute al inicio
    @PostConstruct
    public void init() {

        manejadorOrden = new ManejadorOrden();
        manejadorCategorias = new ManejadorCategorias();
        nuevaOrden = new Orden();

        //para mostrar las categorias
        model = new DefaultMenuModel();
        categorias = manejadorCategorias.Obtener(true);
        nuevaOrden.idOrden = manejadorOrden.ObtenerId();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        for (int i = 0; i < categorias.size(); i++) {
            DefaultMenuItem item = new DefaultMenuItem(categorias.get(i).nombre);
            item.setIcon("ui-icon-arrowthick-1-e");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

    //getter y setter de las propiedades de la orden
    public MenuModel getModel() {
        return model;
    }

    public Orden getNuevaOrden() {
        return nuevaOrden;
    }

    public void setNuevaOrden(Orden nuevaOrden) {
        this.nuevaOrden = nuevaOrden;
    }

    public int getIdOrden() {
        return nuevaOrden.idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.nuevaOrden.idOrden = idOrden;
    }

    public String getNoMesa() {
        return nuevaOrden.mesa;
    }

    public void setNoMesa(String mesa) {
        this.nuevaOrden.mesa = mesa;
    }

    public String getMesero() {
        return nuevaOrden.mesero;
    }

    public void setMesero(String mesero) {
        this.nuevaOrden.mesero = mesero;
    }

    public String getCliente() {
        return nuevaOrden.cliente;
    }

    public void setCliente(String cliente) {
        this.nuevaOrden.cliente = cliente;
    }

    public String getComentario() {
        return nuevaOrden.comentario;
    }

    public void setComentario(String comentario) {
        this.nuevaOrden.comentario = comentario;
    }

    //para hacer pasar a agregar productos
    public void productos() {
        RequestContext context = RequestContext.getCurrentInstance();
        nuevaOrden.fecha = fecha;
        context.execute("PF('addProductos').show();");
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
            manejadorOrden.Insertar(nuevaOrden);
            //si se crea la nueva orden se imprimen los tickets automaticos
            ticket.TicketBebida(nuevaOrden);
            ticket.TicketCocina(nuevaOrden);
        } catch (Exception e) {
            
        }
    }

}
