package RepositoryInterfaces;

import javax.ejb.Local;

import pl.warehouse.entities.Faktura;

@Local
public interface FakturaInterface {

	Faktura saveFaktura(Faktura f);
	
}
