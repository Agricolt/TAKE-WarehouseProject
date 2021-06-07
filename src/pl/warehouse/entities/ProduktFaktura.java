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
public class ProduktFaktura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int idProduktuFaktury;

	@ManyToOne
	private Faktura faktura;
	
	@ManyToOne
	private Produkt produkt;
	
	private Integer iloscSztukKupionych;
	
	public int getIdProduktuFaktury() {
		return idProduktuFaktury;
	}

	public void setIdProduktuFaktury(int idProduktuFaktury) {
		this.idProduktuFaktury = idProduktuFaktury;
	}

	public Faktura getFaktura() {
		return faktura;
	}

	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public Integer getIloscSztukKupionych() {
		return iloscSztukKupionych;
	}

	public void setIloscSztukKupionych(Integer iloscSztukKupionych) {
		this.iloscSztukKupionych = iloscSztukKupionych;
	}

	public ProduktFaktura(Faktura faktura, Produkt produkt, Integer iloscSztukKupionych) {
		super();
		this.faktura = faktura;
		this.produkt = produkt;
		this.iloscSztukKupionych = iloscSztukKupionych;
	}

	public ProduktFaktura() {
		super();
	}
	
}
