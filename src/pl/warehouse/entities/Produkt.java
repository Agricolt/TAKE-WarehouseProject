package pl.warehouse.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pl.warehouse.dto.ProduktDTO;

@Entity
public class Produkt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduktu;

	@ManyToOne
	private Magazyn magazyn;

	private Float cena;

	private String nazwa;

	private Integer iloscNaMagazynie;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "produkt")
	private List<ProduktFaktura> produktyFaktury = new ArrayList<ProduktFaktura>();

	
	public Produkt(ProduktDTO dto){
		
		this.cena = dto.getCena();
		this.nazwa = dto.getNazwa();
		this.iloscNaMagazynie = dto.getIloscNaMagazynie();
	}
	
	
	public Integer getIdProduktu() {
		return idProduktu;
	}

	public void setIdProduktu(Integer idProduktu) {
		this.idProduktu = idProduktu;
	}

	public Float getCena() {
		return cena;
	}

	public void setCena(Float cena) {
		this.cena = cena;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Integer getIloscNaMagazynie() {
		return iloscNaMagazynie;
	}

	public void setIloscNaMagazynie(Integer iloscNaMagazynie) {
		this.iloscNaMagazynie = iloscNaMagazynie;
	}

	public Magazyn getMagazyn() {
		return magazyn;
	}

	public void setMagazyn(Magazyn magazyn) {
		this.magazyn = magazyn;
	}

	public List<ProduktFaktura> getProduktyFaktury() {
		return produktyFaktury;
	}

	public void setProduktyFaktury(List<ProduktFaktura> produktyFaktury) {
		this.produktyFaktury = produktyFaktury;
	}

	public Produkt(Magazyn magazyn, Float cena, String nazwa, Integer iloscNaMagazynie,
			List<ProduktFaktura> produktyFaktury) {
		super();
		this.magazyn = magazyn;
		this.cena = cena;
		this.nazwa = nazwa;
		this.iloscNaMagazynie = iloscNaMagazynie;
		this.produktyFaktury = produktyFaktury;
	}

	public Produkt() {
		super();
	}

}
