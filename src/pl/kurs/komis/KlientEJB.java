package pl.kurs.komis;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import RepositoryInterfaces.FakturaInterface;
import RepositoryInterfaces.KlientInterface;
import RepositoryInterfaces.ProduktInterface;
import pl.warehouse.dto.FakturaDTO;
import pl.warehouse.dto.KlientDTO;
import pl.warehouse.dto.ZamowienieDTO;
import pl.warehouse.entities.Faktura;
import pl.warehouse.entities.Klient;
import pl.warehouse.entities.Produkt;
import pl.warehouse.entities.ProduktFaktura;

@Stateless
public class KlientEJB {
	
	@EJB
	private KlientInterface klientInterface;
	
	@EJB
	private ProduktInterface produktInterface;
	
	@EJB
	private FakturaInterface fakturaInterface;
	
	public KlientDTO getKlientByNazwisko(String nazwisko){
		return new KlientDTO(klientInterface.getKlientByNazwisko(nazwisko));
	}
	
	public KlientDTO getKlientByEmail(String email){
		return new KlientDTO(klientInterface.getKlientByEmail(email));
	}

	public KlientDTO getKlientByTelefon(Integer telefon){
		return new KlientDTO(klientInterface.getKlientByTelefon(telefon));
	}
	
	public KlientDTO getKlientById(Integer id){
		return new KlientDTO(klientInterface.getKlientById(id));
	}
	
	public List<Klient> getAllKlient(){
		return klientInterface.getAllKlient();
	}
	
	public Klient create(KlientDTO dto){
		return klientInterface.saveKlient(new Klient(dto));
	}
	
	public void deleteKlient(Integer id){
		klientInterface.deleteKlient(klientInterface.getKlientById(id));
	}
	
	public void updateKlient(Integer id, KlientDTO dto){
		Klient klient = klientInterface.getKlientById(id);
		
		klient.update(dto);
		klientInterface.saveKlient(klient);
	}
	
	public void createZamowienie(ZamowienieDTO dto){
		
		Klient klient = klientInterface.getKlientByEmail(dto.getEmail());
		
		List<ProduktFaktura> produkty = new ArrayList<>();
		Faktura faktura = new Faktura();
		
		float kwota = 0f;
		Integer i = 0;
		
		
		for(Integer produktId: dto.getProdukty()){
			Produkt produkt = produktInterface.getProduktById(produktId);
			ProduktFaktura pfaktura = new ProduktFaktura();
			pfaktura.setFaktura(faktura);
			pfaktura.setProdukt(produkt);
			pfaktura.setIloscSztukKupionych(dto.getIlosc().get(i));
			kwota += dto.getIlosc().get(i)*produkt.getCena();
			produkt.setIloscNaMagazynie(produkt.getIloscNaMagazynie() - dto.getIlosc().get(i));
			produktInterface.saveProdukt(produkt);
			produkty.add(pfaktura);
			i++;
		}
		
		
		faktura.setKlient(klient);
		faktura.setProduktyFaktury(produkty);
		faktura.setKwota(kwota);
		klient.getFaktury().add(faktura);
		
		fakturaInterface.saveFaktura(faktura);
		
	}
	
	public List<FakturaDTO> getFaktury(String email){
		
		List<Faktura> faktury = klientInterface.getKlientByEmail(email).getFaktury();
		List<FakturaDTO> fakturyDTO = new ArrayList<>();
		for(Faktura faktura: faktury){
			FakturaDTO dto = new FakturaDTO(faktura);
			fakturyDTO.add(dto);
		}
		
		return fakturyDTO;
		
		
	}
	
	public boolean klientLogin(String email){
		
		try{
		Klient klient = klientInterface.getKlientByEmail(email);
		}catch(javax.ejb.EJBTransactionRolledbackException e){
			return false;
		}
		return true;
			
	} 
	
}