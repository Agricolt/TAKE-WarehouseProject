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
public class Faktura {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFaktury;

	@ManyToOne
	private Klient klient;
	
	private float kwota;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="faktura")
	private List<ProduktFaktura> produktyFaktury = new ArrayList<ProduktFaktura>();
	
	public Integer getIdFaktury() {
		return idFaktury;
	}

	public void setIdFaktury(Integer idFaktury) {
		this.idFaktury = idFaktury;
	}
	
	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public float getKwota() {
		return kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}

	public List<ProduktFaktura> getProduktyFaktury() {
		return produktyFaktury;
	}

	public void setProduktyFaktury(List<ProduktFaktura> produktyFaktury) {
		this.produktyFaktury = produktyFaktury;
	}

	public Faktura(Klient klient, float kwota, List<ProduktFaktura> produktyFaktury) {
		super();
		this.klient = klient;
		this.kwota = kwota;
		this.produktyFaktury = produktyFaktury;
	}

	public Faktura() {
		super();
	}
	
	
}
