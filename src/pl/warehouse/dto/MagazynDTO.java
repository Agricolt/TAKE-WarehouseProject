package pl.warehouse.dto;

import pl.warehouse.entities.Magazyn;

public class MagazynDTO {
	private Integer id;
	private String adres;
	
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public MagazynDTO(String adres) {
		super();
		this.id = null;
		this.adres = adres;
	}

	public MagazynDTO(Magazyn magazyn) {
		this.id = magazyn.getIdKMagazynu();
		this.adres = magazyn.getAdres();
	}
	
	public MagazynDTO() {
	}
	
}
