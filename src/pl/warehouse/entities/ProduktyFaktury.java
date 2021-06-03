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
public class ProduktyFaktury {
	private Faktury Faktury_idFaktury;
	
	private Klienci Produkty_idProduktu;
	
	private Integer iloscSztukKupionych;
	
	
	@ManyToOne
	public Faktury getFaktury_idFaktury() {
		return Faktury_idFaktury;
	}

	public void setFaktury_idFaktury(Faktury faktury_idFaktury) {
		Faktury_idFaktury = faktury_idFaktury;
	}
	
	@ManyToOne
	public Klienci getProdukty_idProduktu() {
		return Produkty_idProduktu;
	}

	public void setProdukty_idProduktu(Klienci produkty_idProduktu) {
		Produkty_idProduktu = produkty_idProduktu;
	}

	public Integer getIloscSztukKupionych() {
		return iloscSztukKupionych;
	}

	public void setIloscSztukKupionych(Integer iloscSztukKupionych) {
		this.iloscSztukKupionych = iloscSztukKupionych;
	}
	
	
}
