/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.boundary;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import java.net.URISyntaxException;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Marca;

/**
 *
 * @author dmmaga
 */
@RunWith(Arquillian.class)
public class MarcaRestTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarcaRestTest.class);

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
    
//    @Test
//    public void countTest() throws URISyntaxException{
//        Client client = createClient(); //creamos el cliente
//        WebTarget target = client.target(deploymentURL.toURI()) //registramos el servidor...
//                .path("ws/marca/count"); //.. el path del servicio...
//        LOGGER.info("--- test count marca:{}", target.getUri());
//        int n=target.request(MediaType.TEXT_PLAIN).get(Integer.class);
//        System.out.println("cantidad "+n);
//        
//        Assert.assertEquals(n, 0);
//       
//    }
    
    @Test
    public void createTest() throws URISyntaxException{
        Client client = createClient(); //creamos el cliente
        WebTarget target = client.target(deploymentURL.toURI()) //registramos el servidor...
                .path("ws/marca"); //.. el path del servicio...
        LOGGER.info("--- test create marca:{}", target.getUri());
        Marca prueba = new Marca();
        prueba.setNombre("acer");
        prueba.setIdMarca(1);
        prueba.setDescripcion("hola");
        Response creada = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(prueba, MediaType.APPLICATION_JSON));
//                .post(Entity.entity(prueba, MediaType.APPLICATION_JSON), Marca.class);
       
        System.out.println("creada "+creada);
        
        Assert.assertEquals(creada.getStatus(), 200);
       
    }

    private static Client createClient() {
        return ClientBuilder
                .newBuilder()
                .register(JacksonJaxbJsonProvider.class) //para procesar las peticiones como JSON
                .build();
    }

}
