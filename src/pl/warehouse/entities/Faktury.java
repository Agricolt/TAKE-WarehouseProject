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
public class Faktury {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFaktury;
	
	private Klienci klient;
	
	private float kwota;

	public Integer getIdFaktury() {
		return idFaktury;
	}

	public void setIdFaktury(Integer idFaktury) {
		this.idFaktury = idFaktury;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="Faktury")
	private List<ProduktyFaktury> faktury = new ArrayList<ProduktyFaktury>();
	
	@ManyToOne
	public Klienci getKlient() {
		return klient;
	}

	public void setKlient(Klienci klient) {
		this.klient = klient;
	}

	public float getKwota() {
		return kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}
	
	
}
