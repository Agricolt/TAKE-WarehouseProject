package RepositoryInterfaces;


import java.util.List;

import javax.ejb.Local;

import pl.warehouse.entities.Produkt;
@Local
public interface ProduktInterface {

	Produkt getProduktById(Long id);
	Produkt saveProdukt(Produkt m);
	void deleteProdukt(Produkt m);
	public List<Produkt> getProduktByMagazyn(Integer id);
	public Produkt getProduktById(Integer id);
	public void deleteProduct(Integer productId);
}
