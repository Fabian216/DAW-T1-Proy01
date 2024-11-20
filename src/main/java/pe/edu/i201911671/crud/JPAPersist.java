package pe.edu.i201911671.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201911671.entity.*;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {

            Country country = new Country();
            country.setCode("IM");
            country.setName("EjemploPais01");
            country.setContinent(Continent.Asia);
            country.setRegion("Región llamativa");
            country.setSurfaceArea(12345.67);
            country.setPopulation(500000);
            country.setLocalName("EjemploPais01");
            country.setGovernmentForm("República de Fantasía");
            country.setCode2("IM");

            City city1 = new City();
            city1.setName("Ciudad ejemplo01");
            city1.setDistrict("Distrito Central");
            city1.setPopulation(200000);
            city1.setCountry(country);

            City city2 = new City();
            city2.setName("Villa Salvaje");
            city2.setDistrict("Distrito Este");
            city2.setPopulation(150000);
            city2.setCountry(country);

            City city3 = new City();
            city3.setName("Pueblo Esperanza");
            city3.setDistrict("Distrito Oeste");
            city3.setPopulation(150000);
            city3.setCountry(country);

            country.setCities(Arrays.asList(city1, city2, city3));

            CountryLanguage lang1 = new CountryLanguage();
            CountryLanguageId langId1 = new CountryLanguageId();
            langId1.setCountryCode("IMAG");
            langId1.setLanguage("Fantastico");
            lang1.setId(langId1);
            lang1.setIsOfficial(IsOfficial.T);
            lang1.setPercentage(70.0);
            lang1.setCountry(country);

            CountryLanguage lang2 = new CountryLanguage();
            CountryLanguageId langId2 = new CountryLanguageId();
            langId2.setCountryCode("IMAG");
            langId2.setLanguage("Mágico");
            lang2.setId(langId2);
            lang2.setIsOfficial(IsOfficial.F);
            lang2.setPercentage(30.0);
            lang2.setCountry(country);

            country.setLanguages(Arrays.asList(lang1, lang2));

            em.persist(country);

            em.getTransaction().commit();
            System.out.println("Datos guardados exitosamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error durante la persistencia: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
