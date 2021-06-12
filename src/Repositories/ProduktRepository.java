package Repositories;

import javax.persistence.EntityManager;

import RepositoryInterfaces.ProduktInterface;
import pl.warehouse.entities.Produkt;

public class ProduktRepository implements ProduktInterface {

	private EntityManager em;
	
	public ProduktRepository(EntityManager em){
		this.em = em;
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
