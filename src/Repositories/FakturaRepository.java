package Repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import RepositoryInterfaces.FakturaInterface;
import pl.warehouse.entities.Faktura;
import pl.warehouse.entities.Produkt;

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
	
	@Override
	public List<Faktura> getFakturaKlient(Integer id){
		TypedQuery<Faktura> q = em.createQuery("SELECT f from Faktura f WHERE f.klient.idKlienta = :id",Faktura.class);
		q.setParameter("id", id);
		return q.getResultList();
	}
	
}
