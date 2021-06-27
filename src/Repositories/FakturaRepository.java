package Repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import RepositoryInterfaces.FakturaInterface;
import pl.warehouse.entities.Faktura;

@Stateless
public class FakturaRepository implements FakturaInterface {

	@PersistenceContext(unitName = "warehouse")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Faktura saveFaktura(Faktura f) {
		if (f.getIdFaktury() == null){
			em.persist(f);
		}
		else{
			f = em.merge(f);
		}
		return f;
	}
}
