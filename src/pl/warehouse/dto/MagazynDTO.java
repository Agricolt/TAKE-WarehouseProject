package pl.warehouse.dto;

public class MagazynDTO {
	String adres;

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public MagazynDTO(String adres) {
		super();
		this.adres = adres;
	}

	public MagazynDTO() {
	}
	
}
