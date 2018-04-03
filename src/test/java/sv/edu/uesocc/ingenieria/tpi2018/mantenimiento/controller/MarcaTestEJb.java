/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller;

import javax.ejb.EJB;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MarcaFacade;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.controller.MarcaFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity.Marca;

/**
 *
 * @author rcarlos
 */

@RunWith(Arquillian.class)
public class MarcaTestEJb {

    @EJB
    private MarcaFacadeLocal mf;

 

    @Deployment
    public static Archive<?> createDeployment() {

        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MarcaFacade.class.getPackage())
                .addAsManifestResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

    }

 

    @Test
    public void testCanPersistUserObject() {
        Marca m1 = new Marca();
        m1.setNombre("Marca 1");
        Boolean creado = mf.create(m1);
        System.out.println("CREADO "+creado);
        Assert.assertTrue(true);    

    }
}
