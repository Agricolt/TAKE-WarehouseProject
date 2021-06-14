package Repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
	
	public Produkt getProduktById(Integer id){
		TypedQuery<Produkt> q = em.createQuery("SELECT p from Produkt p WHERE p.idProduktu = :id",Produkt.class);
		q.setParameter("id", id);
		return q.getSingleResult();
	}
	
	
	@Override
	public List<Produkt> getProduktByMagazyn(Integer id){
		TypedQuery<Produkt> q = em.createQuery("SELECT p from Produkt p WHERE p.magazyn.id = :id",Produkt.class);
		q.setParameter("id", id);
		return q.getResultList();
	}

	@Override
	@Transactional
	public Produkt saveProdukt(Produkt p) {
		if (p.getIdProduktu() == null) {
            em.persist(p);
        } else {
            p = em.merge(p);
        }
        return p;
	}

	@Override
	@Transactional
	public void deleteProdukt(Produkt p) {
		 if (em.contains(p)) {
	            em.remove(p);
	        } else {
	            em.merge(p);
	        }
	}
	
	@Override
	@Transactional
	public void deleteProduct(Integer productId) {
	 em.createQuery("delete from Produkt p where p.idProduktu=:id")
	            .setParameter("id", productId)
	            .executeUpdate();  
	}
}
