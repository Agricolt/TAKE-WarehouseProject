package pl.warehouse.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import Repositories.MagazynRepository;
import Repositories.ProduktRepository;


import javax.inject.Inject;

import pl.kurs.komis.ProduktEJB;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Produkt;



@Path("/produkt")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ProduktREST {

	@EJB
	ProduktEJB bean;

	//@Inject
	//MagazynRepository dao;
	
	@GET
	@Path("/adres/{adres}")
	public List<ProduktDTO> getProductsFromMagazyn(@PathParam("adres") String adres){
		return bean.getProduktByMagazyn(adres);
	}
	
	@GET
	@Path("/{id}")
	public ProduktDTO getProduktById(@PathParam("id") Integer id){
		return bean.getProduktById(id);
	}
	
	
	@POST
	public void createProdukt (ProduktDTO dto) {
		 bean.create(dto);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProdukt(@PathParam("id") Integer id){
		bean.deleteProduct(id);
	}
}
