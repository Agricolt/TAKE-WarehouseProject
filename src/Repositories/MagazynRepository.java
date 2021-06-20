package Repositories;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import RepositoryInterfaces.MagazynInterface;
import pl.warehouse.entities.Magazyn;

@Stateless
public class MagazynRepository implements MagazynInterface {

    @PersistenceContext(unitName = "warehouse")
	private EntityManager em;
	
	public MagazynRepository(EntityManager em){
		this.em = em;
	}
	
	
	public MagazynRepository() {
		super();
	}


	@Override
	public Magazyn getMagazynById(Integer id) {
		return em.find(Magazyn.class,id);
	}

	@Override
	public Magazyn getMagazynByAdres(String adres) {
		TypedQuery<Magazyn> q = em.createQuery("SELECT m from Magazyn m WHERE m.adres = :adres",Magazyn.class);
		q.setParameter("adres", adres);
		return q.getSingleResult();
	}


  	@Override
	public List<Magazyn> getAllMagazyn(){
		TypedQuery<Magazyn> q = em.createQuery("SELECT m from Magazyn m", Magazyn.class);
		List<Magazyn> listOfEntities = q.getResultList();
		return listOfEntities;
	}

	@Override					
	@Transactional
  	public Magazyn saveMagazyn(Magazyn m) {
  		em.persist(m);
  		return m;
  	}
  
  	@Override
	@Transactional
  	public void deleteMagazyn(Magazyn m) {
  			if(em.contains(m)){
  				em.remove(m);
  			}
  	}
}
  	
