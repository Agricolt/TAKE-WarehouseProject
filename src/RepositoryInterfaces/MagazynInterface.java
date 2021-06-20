package RepositoryInterfaces;

import java.util.List;

import javax.ejb.Local;

import pl.warehouse.entities.Magazyn;

@Local
public interface MagazynInterface {

	Magazyn getMagazynById(Integer id);
	Magazyn getMagazynByAdres(String adres);
	List<Magazyn> getAllMagazyn();
	Magazyn saveMagazyn(Magazyn m);
	void deleteMagazyn(Magazyn m);
}
