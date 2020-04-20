/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaGenero;


import es.isabeljaimeatienza.catalogoseries.Genero;
import es.isabeljaimeatienza.catalogoseries.Serie;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author cadit
 */
public class ConsultaGenero {

    /**
     *
     * @param args
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Map<String, String> emfProperties = new HashMap<>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoSeriesPU", emfProperties);
        EntityManager em = emf.createEntityManager();
        
        // Encontrar todo lo relacionado con genero 
        Query queryGenero = em.createNamedQuery("Genero.findAll");
        List<Genero> listGenero;
        listGenero = queryGenero.getResultList();
        listGenero.forEach((genero) -> {
            System.out.println(genero.getNombre());
        });
        // Seleccionar un objeto en concreto
        Query queryGeneroRomance = em.createNamedQuery("Genero.findByNombre");
        queryGeneroRomance.setParameter("nombre", "Romance");
        List<Genero> listGeneroRomance =  queryGeneroRomance.getResultList();
        listGeneroRomance.stream().map((generoRomance) -> {
            System.out.print(generoRomance.getId() + ": ");
            return generoRomance;
        }).forEachOrdered((generoRomance) -> {
            System.out.println(generoRomance.getNombre());
        });
        
        // Modificar un codigo
        Query queryGeneroTerror = em.createNamedQuery("Genero.findByNombre");
        queryGeneroTerror.setParameter("nombre", "Terror");
        List<Genero> listGeneroTerror = queryGeneroTerror.getResultList();
        em.getTransaction().begin();
        listGeneroTerror.stream().map((generoTerror) -> {
            generoTerror.setCodigo("TR");
            return generoTerror;
        }).forEachOrdered((generoTerror) -> {
            em.merge(generoTerror);
        });

        // Borrar a través del ID
        Genero generoId335 = em.find(Genero.class,335);
        if (generoId335 != null) {
            em.remove(generoId335);
        } else {
            System.out.println("No hay ningun genero con ID=335");
        }
        em.getTransaction().commit();
        try {
            DriverManager.getConnection("jdbc:derby:CatalogoSeries;shutdown=true");
        } catch (SQLException ex) {
        }
    }

}