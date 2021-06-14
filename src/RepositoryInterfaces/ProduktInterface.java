package RepositoryInterfaces;


import javax.ejb.Local;

import pl.warehouse.entities.Produkt;
@Local
public interface ProduktInterface {

	Produkt getProduktById(Long id);
	Produkt saveProdukt(Produkt m);
	void deleteProdukt(Produkt m);
	
}
