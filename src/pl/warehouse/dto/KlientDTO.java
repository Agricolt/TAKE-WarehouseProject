package pl.warehouse.dto;

import pl.warehouse.entities.Klient;

public class KlientDTO {
	private Integer id;
	
	private String imie;
	
	private String nazwisko;
	
	private String email;
	
	private Integer telefon;

	public KlientDTO(String imie, String nazwisko, String email, Integer telefon) {
		super();
		this.id = null;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.telefon = telefon;
	}
	
	public KlientDTO(Klient klient){
		this.id = klient.getIdKlienta();
		this.imie = klient.getImie();
		this.nazwisko = klient.getNazwisko();
		this.email = klient.getEmail();
		this.telefon = klient.getTelefon();
	}
	
	public KlientDTO(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefon() {
		return telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}
	
	
}
