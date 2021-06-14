package pl.kurs.komis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Repositories.MagazynRepository;
import Repositories.ProduktRepository;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Klient;
import pl.warehouse.entities.Magazyn;
import pl.warehouse.entities.Produkt;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("warehouse");
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();
		
		MagazynRepository magazynRepository = new MagazynRepository(manager);
		ProduktRepository produktRepository = new ProduktRepository(manager);
		
		Klient klient = new Klient("patryk", "osysek", 123456789, "osys@osys.pl");
		ProduktDTO dto  = new ProduktDTO("Piekary",100.0f,"TEST",5);
		
		Magazyn magazyn = magazynRepository.getMagazynByAdres(dto.getAdresMagazynu());
		System.out.print(magazyn.getIdKMagazynu());
		
		Produkt produkt = new Produkt(dto);
		produkt.setMagazyn(magazyn);
		
		produktRepository.saveProdukt(produkt);
		
		
		manager.persist(klient);

		manager.getTransaction().commit();
		manager.close();
		managerFactory.close();

	}
}
