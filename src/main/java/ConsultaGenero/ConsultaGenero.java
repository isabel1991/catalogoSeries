/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaGenero;

import es.isabeljaimeatienza.catalogoseries.Genero;
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
    public static void main(String[] args) {
        Map<String, String> emfProperties = new HashMap<>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoSeriesPU", emfProperties);
        EntityManager em = emf.createEntityManager();
        Query queryGenero = em.createNamedQuery("Genero.findAll");
        List<Genero> listGenero;
        listGenero = queryGenero.getResultList();
        for (Genero genero : listGenero) {
            System.out.println(genero.getNombre());
        }

        try {
            DriverManager.getConnection("jdbc:derby:CatalogoSeries;shutdown=true");
        } catch (SQLException ex) {
        }
    }

}
