package pl.warehouse.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.warehouse.dto.KlientDTO;

@Entity
public class Klient {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idKlienta;
	
	private String imie;
	
	private String nazwisko;
	
	private Integer telefon;
	
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="klient")
	private List<Faktura> faktury = new ArrayList<Faktura>();

	public Integer getIdKlienta() {
		return idKlienta;
	}

	public void setIdKlienta(Integer idKlienta) {
		this.idKlienta = idKlienta;
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

	public Integer getTelefon() {
		return telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Faktura> getFaktury() {
		return faktury;
	}

	public void setFaktury(List<Faktura> faktury) {
		this.faktury = faktury;
	}

	public Klient(String imie, String nazwisko, Integer telefon, String email) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.telefon = telefon;
		this.email = email;
	}

	public Klient() {
		super();
	}
	
	public Klient(KlientDTO dto){
		this.email = dto.getEmail();
		this.imie = dto.getImie();
		this.nazwisko = dto.getNazwisko();
		this.telefon = dto.getTelefon();
	}
	
	public void update(KlientDTO dto){
		this.email = dto.getEmail();
		this.imie = dto.getImie();
		this.nazwisko = dto.getNazwisko();
		this.telefon = dto.getTelefon();
	}
	
}
