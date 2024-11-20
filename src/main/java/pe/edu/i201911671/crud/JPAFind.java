package pe.edu.i201911671.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201911671.entity.City;
import pe.edu.i201911671.entity.Country;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();

        try {
            Country country = em.find(Country.class, "PER");
            if (country != null) {
                List<City> cities = country.getCities();
                cities.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("Ciudad: " + city.getName()));
            } else {
                System.out.println("No se encontró el país con el código 'PER'.");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el país: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

}
