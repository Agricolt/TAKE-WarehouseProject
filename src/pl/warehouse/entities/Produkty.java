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

@Entity
public class Produkty {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProduktu;
	
	private Magazyny Magazyny_idMagazynu;
	
	private Float cena;
	
	private String nazwa;
	
	private Integer iloscNaMagazynie;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="Produkty")
	private List<ProduktyFaktury> faktury = new ArrayList<ProduktyFaktury>();

	public Integer getIdProduktu() {
		return idProduktu;
	}

	public void setIdProduktu(Integer idProduktu) {
		this.idProduktu = idProduktu;
	}

	@ManyToOne
	public Magazyny getMagazyny_idMagazynu() {
		return Magazyny_idMagazynu;
	}

	public void setMagazyny_idMagazynu(Magazyny magazyny_idMagazynu) {
		Magazyny_idMagazynu = magazyny_idMagazynu;
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

	public List<ProduktyFaktury> getFaktury() {
		return faktury;
	}

	public void setFaktury(List<ProduktyFaktury> faktury) {
		this.faktury = faktury;
	}
	
	
}
