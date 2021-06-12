package pl.kurs.komis;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Repositories.MagazynRepository;
import Repositories.ProduktRepository;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Magazyn;
import pl.warehouse.entities.Produkt;

@Stateless
public class ProduktEJB {

	
	private final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("warehouse");
	private final EntityManager manager = managerFactory.createEntityManager();
	private final ProduktRepository produktRepository = new ProduktRepository(this.manager);
	private final MagazynRepository magazynRepository = new MagazynRepository(this.manager);
	
	public Produkt create(ProduktDTO dto) {
		
		
		
		Magazyn magazyn = magazynRepository.getMagazynByAdres(dto.getAdresMagazynu());
		 
		if(magazyn.equals(null))
			return null;
		
		else{
			
			Produkt produkt = new Produkt(dto);
			produkt.setMagazyn(magazyn);
			return produktRepository.saveProdukt(produkt);
		}
		
	}	
}
