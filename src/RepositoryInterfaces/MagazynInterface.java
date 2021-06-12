package RepositoryInterfaces;

import pl.warehouse.entities.Magazyn;

public interface MagazynInterface {

	Magazyn getMagazynById(Long id);
	Magazyn getMagazynByAdres(String adres);
	Magazyn saveMagazyn(Magazyn m);
	void deleteMagazyn(Magazyn m);
}
