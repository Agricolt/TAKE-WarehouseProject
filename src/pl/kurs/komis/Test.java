package pl.kurs.komis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.warehouse.entities.Klient;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("warehouse");
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();
		
		Klient klient = new Klient("patryk", "osysek", 123456789, "osys@osys.pl");
		
		manager.persist(klient);

		manager.getTransaction().commit();
		manager.close();
		managerFactory.close();

	}
}
