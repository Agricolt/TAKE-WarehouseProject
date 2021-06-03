package pl.warehouse.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Magazyny {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idKMagazynu;
	
	private String adres;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy="Magazyny")
	private List<Produkty> faktury = new ArrayList<Produkty>();
}
