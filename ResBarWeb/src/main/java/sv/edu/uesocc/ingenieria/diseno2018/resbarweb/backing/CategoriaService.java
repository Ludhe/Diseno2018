/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.diseno2018.resbarweb.backing;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import sv.edu.diseno.acceso.ManejadorCategorias;
import sv.edu.diseno.definiciones.Categoria;

/**
 *
 * @author doratt
 */

@ManagedBean(name = "categoriaService")
@ApplicationScoped
public class CategoriaService {
    
    ManejadorCategorias mc;
    
    public List<Categoria> crearCategorias(boolean productos){
        List<Categoria> categorias = mc.Obtener(productos);
        return categorias;
    }
    
    
}
