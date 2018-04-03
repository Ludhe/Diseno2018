/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary;

import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Marca;

/**
 *
 * @author dmmaga
 */
@RunWith(Arquillian.class)
public class MarcaTestREST {

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Marca.class.getPackage())
                .addPackage(MarcaFacadeLocal.class.getPackage())
                .addPackage(MarcaRest.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testCreateMarca (@ArquillianResteasyResource("ws/marca") MarcaRest marca) {
       // Given
        final String name = "DELL";
        final int idmarca = 1;
        Marca test = new Marca();
        test.setIdMarca(idmarca);
        test.setNombre(name);
         
        
        // When
        Marca result = marca.create(test);
        System.out.println("**********"+result.getNombre());

        // Then

        assertEquals(result.getNombre(), name);
    }
}
