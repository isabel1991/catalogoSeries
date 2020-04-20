/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.isabeljaimeatienza.catalogoseries;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cadit
 */
public class CatalogoSeries {

    public static void main(String[] args) {
        // Conectar con la base de datos
        Map<String, String> emfProperties = new HashMap<>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoSeriesPU", emfProperties);
        EntityManager em = emf.createEntityManager();

        // REALIZAR AQUÍ LAS OPERACIONES SOBRE LA BASE DE DATOS
        em.getTransaction().begin();
        // GENEROS -------------------------------------------------
        Genero generoRomance = new Genero(null, "Romance");
        Genero generoComedia = new Genero();
        generoComedia.setNombre("Comedia");
        Genero generoTerror = new Genero();
        generoTerror.setNombre("Terror");
        Genero generoSuspense = new Genero();
        generoSuspense.setNombre("Suspense");

        // NACIONALIDAD--------------------------------------
        Nacionalidad nacionalidadEeuu = new Nacionalidad();
        nacionalidadEeuu.setPais("EEUU");
        Nacionalidad nacionalidadSpain = new Nacionalidad();
        nacionalidadSpain.setPais("Espana");
        Nacionalidad nacionalidadFrancia = new Nacionalidad();
        nacionalidadFrancia.setPais("Francia");
        Nacionalidad nacionalidadCorea = new Nacionalidad();
        nacionalidadCorea.setPais("Corea del Sur");

        // IDIOMAS--------------------------------------
        Idioma idiomaIngles = new Idioma();
        idiomaIngles.setCodigo("ENG");
        idiomaIngles.setNombre("Inglés");
        Idioma idiomaSpanish = new Idioma();
        idiomaSpanish.setCodigo("SPA");
        idiomaSpanish.setNombre("Español");
        Idioma idiomaFrances = new Idioma();
        idiomaFrances.setCodigo("FRA");
        idiomaFrances.setNombre("Francés");
        Idioma idiomaCorean = new Idioma();
        idiomaCorean.setCodigo("COR");
        idiomaCorean.setNombre("Coreano");
        //Series-----------------------------------------------------
        Serie itawonClass = new Serie();
        itawonClass.setGenero(generoRomance);
        itawonClass.setTítulo("Itawon Class");
        itawonClass.setValoracion(Boolean.TRUE);
        itawonClass.setPais(nacionalidadSpain);
        itawonClass.setIdioma(idiomaSpanish);
        itawonClass.setPrecio(BigDecimal.valueOf(15.65));
        Serie bongSoon = new Serie();
        bongSoon.setGenero(generoComedia);
        bongSoon.setTítulo("Strong Girl BongSoon");
        bongSoon.setPais(nacionalidadCorea);
        bongSoon.setIdioma(idiomaCorean);
        bongSoon.setValoracion(Boolean.TRUE);
        Serie alosgatosnitocarlos = new Serie();
        alosgatosnitocarlos.setGenero(generoTerror);
        alosgatosnitocarlos.setPais(nacionalidadEeuu);
        alosgatosnitocarlos.setIdioma(idiomaIngles);
        alosgatosnitocarlos.setTítulo("Alosgatos");
        alosgatosnitocarlos.setValoracion(Boolean.FALSE);

        em.persist(generoRomance);
        em.persist(generoComedia);
        em.persist(generoTerror);
        em.persist(nacionalidadEeuu);
        em.persist(nacionalidadSpain);
        em.persist(nacionalidadFrancia);
        em.persist(nacionalidadCorea);
        em.persist(idiomaSpanish);
        em.persist(idiomaIngles);
        em.persist(idiomaFrances);
        em.persist(idiomaCorean);
        em.persist(generoRomance);
        em.persist(itawonClass);
        em.persist(bongSoon);
        em.persist(alosgatosnitocarlos);
        em.getTransaction().commit();
        // Cerrar la conexión con la base de datos
        em.close();
        emf.close();
        try {
            DriverManager.getConnection("jdbc:derby:CatalogoSeries;shutdown=true");
        } catch (SQLException ex) {
        }

    }
}
