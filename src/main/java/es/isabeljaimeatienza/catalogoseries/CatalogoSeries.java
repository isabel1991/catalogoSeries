/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.isabeljaimeatienza.catalogoseries;

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
        Genero generoRomance = new Genero(null, "Romance");
        Genero generoComedia = new Genero();
        generoComedia.setNombre("Comedia");
        Genero generoTerror = new Genero();
        generoTerror.setNombre("Terror");
        Genero generoSuspense = new Genero();
        generoSuspense.setNombre("Suspense");

        Serie itawonClass = new Serie();
        itawonClass.setGenero(generoRomance);
        itawonClass.setTítulo("Itawon Class");
        itawonClass.setValoracion(Boolean.TRUE);
        Serie bongSoon = new Serie();
        bongSoon.setGenero(generoComedia);
        bongSoon.setTítulo("Strong Girl BongSoon");
        bongSoon.setValoracion(Boolean.TRUE);
        Serie alosgatosnitocarlos = new Serie();
        alosgatosnitocarlos.setGenero(generoTerror);
        alosgatosnitocarlos.setTítulo("A los gatos");
        alosgatosnitocarlos.setValoracion(Boolean.FALSE);

        
        em.persist(generoRomance);
        em.persist(generoComedia);
        em.persist(generoTerror);
        em.persist(generoSuspense);
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
