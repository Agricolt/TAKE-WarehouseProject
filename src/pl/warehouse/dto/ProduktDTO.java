package pl.warehouse.dto;



public class ProduktDTO {

	private String adresMagazynu;
	
	private Float cena;

	private String nazwa;

	private Integer iloscNaMagazynie;

	public ProduktDTO(String adresMagazynu, Float cena, String nazwa, Integer iloscNaMagazynie) {
		super();
		this.adresMagazynu = adresMagazynu;
		this.cena = cena;
		this.nazwa = nazwa;
		this.iloscNaMagazynie = iloscNaMagazynie;
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
	
	
}
