package Repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import RepositoryInterfaces.KlientInterface;
import pl.warehouse.entities.Klient;
import pl.warehouse.entities.Magazyn;

@Stateless
public class KlientRepository implements KlientInterface {
	@PersistenceContext(unitName = "warehouse")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Klient getKlientById(Integer Id) {
		return em.find(Klient.class, Id);
	}

	@Override
	public Klient getKlientByNazwisko(String nazwisko) {
		TypedQuery<Klient> q = em.createQuery("SELECT k from Klient k WHERE k.nazwisko = :nazwisko", Klient.class);
		q.setParameter("nazwisko", nazwisko);
		return q.getSingleResult();
	}

	@Override
	public Klient getKlientByTelefon(Integer nrTelefonu) {
		TypedQuery<Klient> q = em.createQuery("SELECT k from Klient k WHERE k.nazwisko = :nrTelefonu", Klient.class);
		q.setParameter("nrTelefonu", nrTelefonu);
		return q.getSingleResult();
	}

	@Override
	public Klient getKlientByEmail(String email) {
		TypedQuery<Klient> q = em.createQuery("SELECT k from Klient k WHERE k.nazwisko = :email", Klient.class);
		q.setParameter("email", email);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public List<Klient> getAllKlient() {
		TypedQuery<Klient> q = em.createQuery("SELECT k from Klient k", Klient.class);
		List<Klient> listOfEntities = q.getResultList();
		return listOfEntities;
	}

	@Override
	@Transactional
	public Klient saveKlient(Klient k) {
		if (k.getIdKlienta() == null){
			em.persist(k);
		}
		else{
			k = em.merge(k);
		}
		return k;
	}

	@Override
	@Transactional
	public void deleteKlient(Klient k) {
		if (em.contains(k)){
			em.remove(k);
		}
		else{
			em.merge(k);
		}
	}
	
	
	
}
