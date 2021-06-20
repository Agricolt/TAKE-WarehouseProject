package pl.kurs.komis;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Repositories.MagazynRepository;
import Repositories.ProduktRepository;
import RepositoryInterfaces.MagazynInterface;
import RepositoryInterfaces.ProduktInterface;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Magazyn;
import pl.warehouse.entities.Produkt;

@Stateless
public class ProduktEJB {

	@EJB
    private  ProduktInterface produktRepository;
	@EJB
    private  MagazynInterface magazynRepository;
    
    
	
    
	public Produkt create(ProduktDTO dto) {
		
		Magazyn magazyn = magazynRepository.getMagazynByAdres(dto.getAdresMagazynu());
		 
		if(magazyn.equals(null))
			return null;
		else{
			
			Produkt produkt = new Produkt(dto);
			produkt.setMagazyn(magazyn);
			return produktRepository.saveProdukt(produkt);
		}
		
	}

	public List<ProduktDTO> getProduktByMagazyn(String adres){
		
		Magazyn magazyn = magazynRepository.getMagazynByAdres(adres);
		
		List<Produkt> produkty = produktRepository.getProduktByMagazyn(magazyn.getIdKMagazynu());
		List<ProduktDTO> produktyDTO = new ArrayList<>();
			for(Produkt produkt: produkty){
				
				ProduktDTO dto = new ProduktDTO(produkt);
				produktyDTO.add(dto);
			}
		return produktyDTO;
	}
	
	public ProduktDTO getProduktById(Integer id){
		return new ProduktDTO(produktRepository.getProduktById(id));
	}
	
	public void deleteProdukt(Integer id){
		produktRepository.deleteProdukt(produktRepository.getProduktById(id));
	}
	
	public void deleteProduct(Integer id){
		produktRepository.deleteProduct(id);
	}
	
	public void updateProdukt(Integer id, ProduktDTO dto){
		
		Produkt produkt = produktRepository.getProduktById(id);
		Magazyn magazyn = magazynRepository.getMagazynByAdres(dto.getAdresMagazynu());
		
		produkt.update(dto, magazyn);
		produktRepository.saveProdukt(produkt);
	}
	
	
}
