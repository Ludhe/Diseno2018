/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
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
import sv.edu.diseno.definiciones.DetalleOrdenPK;
import sv.edu.diseno.definiciones.Orden;
import sv.edu.diseno.definiciones.Producto;
import sv.edu.uesocc.ingenieria.diseno2018.resbarweb.ticket.NuevoTicket;

/**
 *
 * @author dmmaga
 */
@ManagedBean
@ViewScoped
public class frmNuevaOrden implements Serializable {

    ManejadorOrden manejadorOrden;
    private Orden nuevaOrden;

    ManejadorCategorias manejadorCategorias;
    private List<Categoria> categorias;
    private Categoria selectedCategoria;

    private Producto selectedProducto;
    private int cantidadProducto = 1;
    private DetalleOrden selectedDetalleOrden;

    private MenuModel model;

    //Metodos De la Importantes del FRM
    @PostConstruct
    public void init() {
        nuevaOrden = new Orden();
        nuevaOrden.setIdOrden(manejadorOrden.ObtenerId());

        cantidadProducto = 1;
        categorias = manejadorCategorias.Obtener(true);

        model = new DefaultMenuModel();
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("CATEGORÍAS");
        for (Categoria categoria : categorias) {
            DefaultMenuItem item = new DefaultMenuItem(categoria.getNombre());
            item.setCommand("#{frmNuevaOrden.selectCategoria(" + categoria.getIdCategoria() + ")}");
            item.setUpdate("productosTabla");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

    public void saveDetalleOrden() {
        RequestContext context = RequestContext.getCurrentInstance();
        //FacesContext context2 = FacesContext.getCurrentInstance();
        List<DetalleOrden> list = nuevaOrden.getDetalleOrdenList();

        boolean exist = false;
        for (DetalleOrden detOrd : list) {
            if (selectedDetalleOrden.getOrden().getIdOrden().equals(detOrd.getOrden().getIdOrden())
                    && selectedDetalleOrden.getProducto().getIdProducto().equals(detOrd.getProducto().getIdProducto())) {
                //Producto ya exisite entonces solo sumar el nuevo valor
                int v = selectedDetalleOrden.getCantidad().intValue() + detOrd.getCantidad().intValue();
                detOrd.setCantidad(new BigDecimal((double) v));
                //manejadorOrden.Actualizar(selectedOrden);
                exist = true;
                break;
            }

        }

        if (!exist) {
            //Creando el Detalle Orden
            BigDecimal cantidad = new BigDecimal(cantidadProducto);
            Orden ord = nuevaOrden;
            Producto pro = selectedProducto;
            DetalleOrdenPK detOrdPri = new DetalleOrdenPK(ord.idOrden, pro.idProducto);
            DetalleOrden detOrd = new DetalleOrden(detOrdPri, cantidad);
            detOrd.setProducto(pro);
            detOrd.setOrden(ord);
            list.add(detOrd);
            nuevaOrden.setDetalleOrdenList(list);
        }

        nuevaOrden.CalcularTotal();
        //manejadorOrden.Actualizar(nuevaOrden);        
        //Mandar a Imprimir la tempList antes de borrarla
        clearAllSelectionAgregarProducto();
        context.execute("PF('agregarProductoDialog').hide();");
    }

    public void guardar() {
        if (!nuevaOrden.detalleOrdenList.isEmpty()) {
            nuevaOrden.fecha = Date.from(Instant.now());
            nuevaOrden.activa = true;
            manejadorOrden.Insertar(nuevaOrden);
            NuevoTicket ticket = new NuevoTicket();
            boolean cocina = false, bebidas = false;
            for (DetalleOrden detalleOrden : nuevaOrden.detalleOrdenList) {
                if (detalleOrden.producto.area == 'C') {
                    cocina = true;
                }
                if (detalleOrden.producto.area == 'B') {
                    bebidas = true;
                }
            }
            if (bebidas) {
                ticket.TicketExtraBebida(nuevaOrden.detalleOrdenList);
            }
            if (cocina) {
                ticket.TicketExtraCocina(nuevaOrden.detalleOrdenList);
            }
        } else {
            System.out.println("la lista de productos esta vacia");
        }

    }

    public void clearAllSelectionAgregarProducto() {
        selectedCategoria = null;
        selectedProducto = null;
        cantidadProducto = 1;
    }

    public void selectCategoria(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (idCategoria == categoria.getIdCategoria()) {
                selectedCategoria = categoria;
                break;
            }
        }
    }

    public void initDetalleOrden() {
        if (nuevaOrden.idOrden != null && !nuevaOrden.mesa.isEmpty() || !nuevaOrden.mesero.isEmpty() || !nuevaOrden.cliente.isEmpty()) {
            this.nuevaOrden.setDetalleOrdenList(new ArrayList<DetalleOrden>());
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('agregarProductoDialog').show();");
        } else {
            System.out.println("No se pueden dejar campos vacios");
        }

    }

    //GETTERS Y SETTER PARA NUEVA ORDEN
    public Orden getNuevaOrden() {
        return nuevaOrden;
    }

    public void setNuevaOrden(Orden nuevaOrden) {
        this.nuevaOrden = nuevaOrden;
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

    //GETTERS Y SETTER DEL MODELO MENU
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    //GETTERS Y SETTER DEL PRODUCTO SELECIONADO
    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    //GETTERS Y SETTER DE LA CANTIDAD
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public DetalleOrden getSelectedDetalleOrden() {
        return selectedDetalleOrden;
    }

    public void setSelectedDetalleOrden(DetalleOrden selectedDetalleOrden) {
        this.selectedDetalleOrden = selectedDetalleOrden;
    }

}
