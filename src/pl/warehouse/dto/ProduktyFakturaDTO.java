package pl.warehouse.dto;

import pl.warehouse.entities.ProduktFaktura;

public class ProduktyFakturaDTO {

	private Integer id;
	
	private ProduktDTO produkt;
	private Integer ilosc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProduktDTO getProdukt() {
		return produkt;
	}
	public void setProdukt(ProduktDTO produkt) {
		this.produkt = produkt;
	}
	public Integer getIlosc() {
		return ilosc;
	}
	public void setIlosc(Integer ilosc) {
		this.ilosc = ilosc;
	}
	
	public ProduktyFakturaDTO(Integer id, ProduktDTO produkt, Integer ilosc) {
		super();
		this.id = id;
		this.produkt = produkt;
		this.ilosc = ilosc;
	}
	public ProduktyFakturaDTO() {
		super();
	}

	public ProduktyFakturaDTO(ProduktFaktura pfaktura){
		
		this.id = pfaktura.getIdProduktuFaktury();
		this.produkt = new ProduktDTO(pfaktura.getProdukt());
		this.ilosc = pfaktura.getIloscSztukKupionych();
		
	}
	
}
