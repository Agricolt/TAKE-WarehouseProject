package Repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import RepositoryInterfaces.ProduktInterface;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Magazyn;
import pl.warehouse.entities.Produkt;

@Stateless
public class ProduktRepository implements ProduktInterface {

	
    @PersistenceContext(unitName = "warehouse")
	private EntityManager em;
	
	//private final MagazynRepository magazynRepository = new MagazynRepository(em);
	
	
	public ProduktRepository(EntityManager em){
		this.em = em;
	}
	
	
	public ProduktRepository() {
		super();
	}


	@Override
	public Produkt getProduktById(Long id) {
		return em.find(Produkt.class, id);
	}

	@Override
	public Produkt saveProdukt(Produkt p) {
		if (p.getIdProduktu() == null) {
            em.persist(p);
        } else {
            p = em.merge(p);
        }
        return p;
	}

	@Override
	public void deleteProdukt(Produkt p) {
		 if (em.contains(p)) {
	            em.remove(p);
	        } else {
	            em.merge(p);
	        }
	}
	
}
