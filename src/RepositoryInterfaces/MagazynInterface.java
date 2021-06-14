package RepositoryInterfaces;

import javax.ejb.Local;

import pl.warehouse.entities.Magazyn;

@Local
public interface MagazynInterface {

	Magazyn getMagazynById(Long id);
	Magazyn getMagazynByAdres(String adres);
	Magazyn saveMagazyn(Magazyn m);
	void deleteMagazyn(Magazyn m);
}
