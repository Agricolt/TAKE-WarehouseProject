package RepositoryInterfaces;


import pl.warehouse.entities.Produkt;

public interface ProduktInterface {

	Produkt getProduktById(Long id);
	Produkt saveProdukt(Produkt m);
	void deleteProdukt(Produkt m);
	
}
