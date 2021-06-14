package pl.warehouse.dto;

import pl.warehouse.entities.Produkt;

public class ProduktDTO {
	
	private Integer id;
	
	private String adresMagazynu;
	
	private Float cena;

	private String nazwa;

	private Integer iloscNaMagazynie;

	public ProduktDTO(String adresMagazynu, Float cena, String nazwa, Integer iloscNaMagazynie) {
		super();
		this.id = null;
		this.adresMagazynu = adresMagazynu;
		this.cena = cena;
		this.nazwa = nazwa;
		this.iloscNaMagazynie = iloscNaMagazynie;
	}

	public ProduktDTO(Produkt produkt){
		this.id = produkt.getIdProduktu();
		this.adresMagazynu = produkt.getMagazyn().getAdres();
		this.cena = produkt.getCena();
		this.nazwa = produkt.getNazwa();
		this.iloscNaMagazynie = produkt.getIloscNaMagazynie();
	}
	
	public ProduktDTO() {
		super();
	}

	public String getAdresMagazynu() {
		return adresMagazynu;
	}

	public void setAdresMagazynu(String adresMagazynu) {
		this.adresMagazynu = adresMagazynu;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
