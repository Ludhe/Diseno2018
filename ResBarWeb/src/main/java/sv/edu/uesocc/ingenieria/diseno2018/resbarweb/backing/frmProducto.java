/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.edu.diseno.acceso.ManejadorProductos;
import sv.edu.diseno.definiciones.Producto;

/**
 *
 * @author dmmaga
 */ 

@ManagedBean(name="dtBasicView")
@ViewScoped
public class frmProducto implements Serializable{
    
    ManejadorProductos manejadorProducto;
    private List<Producto> productos;

    public void setProductos(List<Producto> ordenes) {
        this.productos = productos;
    }
    
    public List<Producto> getProductos() {
        return manejadorProducto.ObtenerxCategoria(0);
    }
    
}
