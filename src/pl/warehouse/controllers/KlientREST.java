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

import pl.kurs.komis.KlientEJB;
import pl.warehouse.dto.KlientDTO;
import pl.warehouse.entities.Klient;

@Path("/klient")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class KlientREST {

	@EJB
	KlientEJB bean;
	
	@GET
	@Path("/telefon/{telefon}")
	public KlientDTO getKlientByTelefon(@PathParam("telefon") Integer telefon){
		return bean.getKlientByTelefon(telefon);
	}
	
	@GET
	@Path("/email/{email}")
	public KlientDTO getKlientByEmail(@PathParam("email") String email){
		return bean.getKlientByEmail(email);
	}
	
	@GET
	@Path("/nazwisko/{nazwisko}")
	public KlientDTO getKlientByAddress(@PathParam("nazwisko") String nazwisko){
		return bean.getKlientByNazwisko(nazwisko);
	}
	
	@GET
	@Path("/{id}")
	public KlientDTO getKlientById(@PathParam("id") Integer id){
		return bean.getKlientById(id);
	}
	
	@GET
	public List<Klient> getAllKlient(){
		return bean.getAllKlient();
	}
	
	@POST
	public void createKlient (KlientDTO dto) {
		 bean.create(dto);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteKlient(@PathParam("id") Integer id){
		bean.deleteKlient(id);
	}
	
	@PUT
	@Path("/{id}")
	public void updateKlient(@PathParam("id") Integer id, KlientDTO dto){
		bean.updateKlient(id, dto);
	}
}