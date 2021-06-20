package pl.kurs.komis;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import Repositories.KlientRepository;
import pl.warehouse.dto.KlientDTO;
import pl.warehouse.entities.Klient;

@Stateless
public class KlientEJB {
	
	@EJB
	private KlientRepository klientRepository;
	
	public KlientDTO getKlientByNazwisko(String nazwisko){
		return new KlientDTO(klientRepository.getKlientByNazwisko(nazwisko));
	}
	
	public KlientDTO getKlientByEmail(String email){
		return new KlientDTO(klientRepository.getKlientByEmail(email));
	}

	public KlientDTO getKlientByTelefon(Integer telefon){
		return new KlientDTO(klientRepository.getKlientByTelefon(telefon));
	}
	
	public KlientDTO getKlientById(Integer id){
		return new KlientDTO(klientRepository.getKlientById(id));
	}
	
	public List<Klient> getAllKlient(){
		return klientRepository.getAllKlient();
	}
	
	public Klient create(KlientDTO dto){
		return klientRepository.saveKlient(new Klient(dto));
	}
	
	public void deleteKlient(Integer id){
		klientRepository.deleteKlient(klientRepository.getKlientById(id));
	}
	
	public void updateKlient(Integer id, KlientDTO dto){
		Klient klient = klientRepository.getKlientById(id);
		
		klient.update(dto);
		klientRepository.saveKlient(klient);
	}
	
}
