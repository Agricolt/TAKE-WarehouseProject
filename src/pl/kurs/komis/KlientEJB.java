package pl.kurs.komis;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import RepositoryInterfaces.KlientInterface;
import pl.warehouse.dto.KlientDTO;
import pl.warehouse.entities.Klient;

@Stateless
public class KlientEJB {
	
	@EJB
	private KlientInterface klientInterface;
	
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
	
}
