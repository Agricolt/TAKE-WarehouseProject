package RepositoryInterfaces;

import java.util.List;

import javax.ejb.Local;

import pl.warehouse.entities.Klient;

@Local
public interface KlientInterface {
	
	Klient getKlientById(Integer Id);
	
	Klient getKlientByNazwisko(String nazwisko);
	
	Klient getKlientByTelefon(Integer nrTelefonu);
	
	Klient getKlientByEmail(String email);
	
	List<Klient> getAllKlient();
	
	Klient saveKlient(Klient k);
	
	void deleteKlient(Klient k);


}
