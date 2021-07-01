package pl.warehouse.dto;

import java.util.ArrayList;
import java.util.List;

import pl.warehouse.entities.Faktura;
import pl.warehouse.entities.ProduktFaktura;

public class FakturaDTO {

	private Integer id;
	
	private float kwota;
	
	private List<ProduktyFakturaDTO> produktyFaktura = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getKwota() {
		return kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}

	public List<ProduktyFakturaDTO> getPfaktura() {
		return produktyFaktura;
	}

	public void setPfaktura(List<ProduktyFakturaDTO> pfaktura) {
		this.produktyFaktura = pfaktura;
	}

	public FakturaDTO(Integer id, float kwota, List<ProduktyFakturaDTO> pfaktura) {
		super();
		this.id = id;
		this.kwota = kwota;
		this.produktyFaktura = pfaktura;
	}

	public FakturaDTO() {
		super();
	}
	
	public FakturaDTO(Faktura faktura){
		this.id = faktura.getIdFaktury();
		this.kwota = faktura.getKwota();
		
		for(ProduktFaktura produkt: faktura.getProduktyFaktury()){
			ProduktyFakturaDTO dto = new ProduktyFakturaDTO(produkt);
			this.produktyFaktura.add(dto);
		}
	}
	
	
}
