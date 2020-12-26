package lab;

import airlines.entities.Flight;
import generator.FlightRandomGenerator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("airlines");
        EntityManager manager = emf.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        Flight flight = new FlightRandomGenerator().next();
        System.out.println(flight);
        PersistTree persistTree = new PersistTree(manager);
        persistTree.persist(flight);

        transaction.commit();
        manager.close();
        emf.close();
    }
}
