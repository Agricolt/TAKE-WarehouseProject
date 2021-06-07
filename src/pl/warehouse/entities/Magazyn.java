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

@Entity
public class Magazyn {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idKMagazynu;
	
	private String adres;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="magazyn")
	private List<Produkt> produkty = new ArrayList<Produkt>();

	public Integer getIdKMagazynu() {
		return idKMagazynu;
	}

	public void setIdKMagazynu(Integer idKMagazynu) {
		this.idKMagazynu = idKMagazynu;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public List<Produkt> getProdukty() {
		return produkty;
	}

	public void setProdukty(List<Produkt> produkty) {
		this.produkty = produkty;
	}

	public Magazyn(String adres, List<Produkt> produkty) {
		super();
		this.adres = adres;
		this.produkty = produkty;
	}

	public Magazyn() {
		super();
	}
	
}
