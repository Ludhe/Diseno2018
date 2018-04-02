/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.mantenimiento.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author rcarlos
 */
@RunWith(Arquillian.class)
public class MarcaTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(Marca.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private static final String[] MARCA_TITLES = {
        "Marca 1",
        "Marca 2",
        "Marca 3"
    };

    @PersistenceContext
    EntityManager em;

    @Inject
    UserTransaction utx;

    @Before
    public void preparePersistenceTest() throws Exception {
        clearData();
        insertData();
        startTransaction();
    }

    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Descartando registros obsoletos...");
        em.createQuery("DELETE FROM Marca").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Insertando registros...");
        for (String title : MARCA_TITLES) {
            Marca marc = new Marca();
            marc.setNombre(title);
            em.persist(marc);
        }
        utx.commit();
        // Vacía el contexto de persistencia (cache de primer nivel)
        em.clear();
    }

    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }

    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }

    @Test
    public void shouldFindAllGamesUsingJpqlQuery() throws Exception {
        // Dado que (given)
        String fetchingAllGamesInJpql = "select m from Marca m";

        // cuando (when)
        System.out.println("Consultando (usando JPQL)...");
        List<Marca> marcas = em.createQuery(fetchingAllGamesInJpql, Marca.class).getResultList();

        // entonces (then)
        System.out.println("Encontrado(s) " + marcas.size() + " marcas (usando JPQL):");
        assertContainsAllMarcas(marcas);
    }

    private static void assertContainsAllMarcas(Collection<Marca> retrievedGames) {
        Assert.assertEquals(MARCA_TITLES.length, retrievedGames.size());
        final Set<String> retrievedMarcaTitles = new HashSet<String>();
        for (Marca m : retrievedGames) {
            System.out.println("* " + m);
            retrievedMarcaTitles.add(m.getNombre());
        }
        Assert.assertTrue(retrievedMarcaTitles.containsAll(Arrays.asList(MARCA_TITLES)));
    }

}
