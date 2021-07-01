package pl.warehouse.dto;

import java.util.List;

public class ZamowienieDTO {

	private String email;
	
	private List<Integer> produkty;

	private List<Integer> ilosc;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public ZamowienieDTO(String email, List<Integer> produkty, List<Integer> ilosc) {
		super();
		this.email = email;
		this.produkty = produkty;
		this.ilosc = ilosc;
	}

	public ZamowienieDTO() {
		super();
	}
	
	
	

	
	
	
	
}
