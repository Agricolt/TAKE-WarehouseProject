package pl.warehouse.dto;

import java.util.List;

public class ZamowienieDTO {

	private Integer klientId;
	
	private List<Integer> produkty;

	private List<Integer> ilosc;
	
	
	

	public ZamowienieDTO(Integer klientId, List<Integer> produkty, List<Integer> ilosc) {
		super();
		this.klientId = klientId;
		this.produkty = produkty;
		this.ilosc = ilosc;
	}

	public Integer getKlientId() {
		return klientId;
	}

	public void setKlientId(Integer klientId) {
		this.klientId = klientId;
	}

	public List<Integer> getProdukty() {
		return produkty;
	}

	public void setProdukty(List<Integer> produkty) {
		this.produkty = produkty;
	}

	public List<Integer> getIlosc() {
		return ilosc;
	}

	public void setIlosc(List<Integer> ilosc) {
		this.ilosc = ilosc;
	}

	public ZamowienieDTO() {
		super();
	}
	
	
	
}
