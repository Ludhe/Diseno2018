/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rcarlos
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {        
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.CalendarioExcepcionResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.CalendarioResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EquipoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EstadoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.MarcaRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.ModeloRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.OrdenTrabajoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.PasoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.PrioridadRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.SolicitudResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.SubTipoMantenimientoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoMantenimientoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoParteResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoResponsableResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.UnidadResources.class);
    }

}
