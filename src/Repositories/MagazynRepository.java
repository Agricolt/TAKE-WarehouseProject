package Repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public Magazyn getMagazynById(Long id) {
		return em.find(Magazyn.class,id);
	}

	@Override
	public Magazyn getMagazynByAdres(String adres) {
		TypedQuery<Magazyn> q = em.createQuery("SELECT m from Magazyn m WHERE m.adres = :adres",Magazyn.class);
		q.setParameter("adres", adres);
		return q.getSingleResult();
	}

	@Override
	public Magazyn saveMagazyn(Magazyn m) {
		if(m.getIdKMagazynu()==null){
			em.persist(m);
		}
		else{
			m = em.merge(m);
		}
			return m;
	}

	@Override
	public void deleteMagazyn(Magazyn m) {
			if(em.contains(m)){
				em.remove(m);
			}else{
				em.merge(m);
			}
	}
}