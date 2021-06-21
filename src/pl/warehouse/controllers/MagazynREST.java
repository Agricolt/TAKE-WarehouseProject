package pl.warehouse.controllers;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.kurs.komis.MagazynEJB;
import pl.warehouse.dto.MagazynDTO;
import pl.warehouse.entities.Magazyn;


@Path("/magazyny")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MagazynREST {
	
	@EJB
	MagazynEJB bean;
  
  	@GET
	@Path("/adres/{adres}")
	public MagazynDTO getMagazynByAddress(@PathParam("adres") String adres){
		return bean.getMagazynByAddress(adres);
  	}
  	
	@GET
	@Path("/{id}")
	public MagazynDTO getMagazynById(@PathParam("id") Integer id){
		return bean.getMagazynById(id);
	}
  	
	@GET
	public List<Magazyn> getAllMagazyn(){
		return bean.getAllMagazyn();
	}
  	
  	@POST
	public void createMagazyn (MagazynDTO dto) {
		 bean.create(dto);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteMagazyn(@PathParam("id") Integer id){
		bean.deleteMagazyn(id);
	}
	
	@PUT
	@Path("/{id}")
	public void updateProdukt(@PathParam("id") Integer id, MagazynDTO dto){
		bean.updateMagazyn(id, dto);
}
}