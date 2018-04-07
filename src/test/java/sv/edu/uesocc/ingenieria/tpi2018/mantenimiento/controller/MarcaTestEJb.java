/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import javax.ejb.EJB;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Marca;

/**
 *
 * @author rcarlos
 */
@RunWith(Arquillian.class)
public class MarcaTestEJb {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarcaTestEJb.class);

    @EJB
    private MarcaFacadeLocal mfl;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "payara-arquillian.war")
                .addPackage(MarcaFacade.class.getPackage())
                .addPackage(Marca.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

//    @Test
//    public void test01() {
//        LOGGER.info("Test 01");
//    }

    @Test
    public void testInsertProducts() {
        LOGGER.info("Test 02");
        Marca m1 = new Marca();
        m1.setNombre("nombre marca");
        Marca creado = mfl.crear(m1);
        System.out.println("Creado: " + creado);
        LOGGER.info("creado:{}", creado);
        Assert.assertEquals(m1.getNombre(), creado.getNombre());
        System.out.println("HACE EL TEST EJB WUJUUUU**************");
    }

}
