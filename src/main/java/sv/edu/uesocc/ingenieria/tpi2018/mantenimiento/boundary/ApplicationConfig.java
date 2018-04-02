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
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.ClassNotFoundExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.ConversionExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.DatabaseExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.EntityExistsExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.EntityNotFoundExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.IOExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.IllegalAccessExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.IllegalArgumentExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.IllegalStateExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.InvocationTargetExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.JAXBExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.JPARSConfigurationExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.JPARSExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.MalformedURLExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.NamingExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.NoResultExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.NoSuchMethodExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.NonUniqueResultExceptionExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.OptimisticLockExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.PersistenceExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.PessimisticLockExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.QueryTimeoutExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.RollbackExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.TransactionRequiredExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.UnsupportedMediaTypeExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.EntityResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.PersistenceResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.PersistenceUnitResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.QueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.SingleResultQueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.EntityResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.PersistenceResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.PersistenceUnitResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.QueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.SingleResultQueryResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.CalendarioExcepcionResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.CalendarioResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.DiagnosticoParteResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.DiagnosticoResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EquipoDetalleResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EquipoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EstadoMantenimientoDetalleResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.EstadoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.MantenimientoDetalleResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.MarcaRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.ModeloRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.OrdenTrabajoCalendarioResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.OrdenTrabajoRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.ParteResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.PasoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.PrioridadRest.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.ProcedimientoResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.ResponsableResource.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.SolicitudResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.SubTipoMantenimientoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoMantenimientoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoParteResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.TipoResponsableResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary.UnidadResources.class);
    }

}
