package RepositoryInterfaces;

import java.util.List;

import javax.ejb.Local;

import pl.warehouse.entities.Faktura;

@Local
public interface FakturaInterface {

	Faktura saveFaktura(Faktura f);
	List<Faktura> getFakturaKlient(Integer id);
	
}
