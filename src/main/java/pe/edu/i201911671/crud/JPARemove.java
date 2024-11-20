package pe.edu.i201911671.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201911671.entity.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        try {
            Country country = em.find(Country.class, "IM");  // Buscar por el código del país

            if (country != null) {
                em.remove(country);
                System.out.println("El país y sus entidades relacionadas han sido eliminados.");
            } else {
                System.out.println("No se encontró el país con el código especificado.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error durante la eliminación: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
