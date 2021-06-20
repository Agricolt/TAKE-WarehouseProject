package pl.kurs.komis;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import RepositoryInterfaces.MagazynInterface;
import pl.warehouse.dto.MagazynDTO;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Magazyn;
import pl.warehouse.entities.Produkt;

@Stateless
public class MagazynEJB {
	
	@EJB
    private  MagazynInterface magazynRepository;
   
	public Magazyn create(MagazynDTO dto) {
		Magazyn magazyn = new Magazyn(dto);
		return magazynRepository.saveMagazyn(magazyn);
	}
	
	public MagazynDTO getMagazynById(Integer id){
		return new MagazynDTO(magazynRepository.getMagazynById(id));
	}
	
	public MagazynDTO getMagazynByAddress(String adres){
		return new MagazynDTO(magazynRepository.getMagazynByAdres(adres));
	}
	
	public List<Magazyn> getAllMagazyn(){
		return magazynRepository.getAllMagazyn();
	}
	
	public void deleteMagazyn(Integer id){
		magazynRepository.deleteMagazyn(magazynRepository.getMagazynById(id));
	}
	
	public void updateMagazyn(Integer id, MagazynDTO dto){
		Magazyn magazyn = magazynRepository.getMagazynById(id);
		
		magazyn.update(dto);
		magazynRepository.saveMagazyn(magazyn);
	}
	
	
}
