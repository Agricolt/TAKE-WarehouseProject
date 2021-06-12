package pl.warehouse.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.kurs.komis.ProduktEJB;
import pl.warehouse.dto.ProduktDTO;
import pl.warehouse.entities.Produkt;



@Path("/produkt")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ProduktREST {

	@EJB
	ProduktEJB bean;

	@POST
	public void ProduktDTO (ProduktDTO dto) {
		 bean.create(dto);
	}
}
