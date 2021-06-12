package pl.warehouse.controllers;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


import pl.warehouse.entities.Magazyn;


@Path("/magazyny")
public class MagazynREST {
	

	@GET 
    public Response listReservations() {
        return Response.ok("Oto wszystkie rezerwacje :)").build();
    }
	
	

	@POST
	public String create(String requestBody) {
		return "car created!";
	}
}
