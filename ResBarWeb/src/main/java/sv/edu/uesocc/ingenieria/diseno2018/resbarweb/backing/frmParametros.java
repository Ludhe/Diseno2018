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
import sv.edu.diseno.acceso.ManejadorParametros;
import sv.edu.diseno.definiciones.Parametro;

/**
 *
 * @author andrea
 */
@ManagedBean(name = "frmParametros")
@ViewScoped
public class frmParametros implements Serializable{
    ManejadorParametros manejadorParametros;
    private List<Parametro> parametros;
    private Parametro selectedParametro;

    public Parametro getSelectedParametro() {
        return selectedParametro;
    }

    public void setSelectedParametro(Parametro selectedParametro) {
        this.selectedParametro = selectedParametro;
    }

    public List<Parametro> getParametros() {
        return manejadorParametros.Obtener();
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }
     public void modificarParametro(){
            manejadorParametros.Actualizar(selectedParametro);
    }
    
}
