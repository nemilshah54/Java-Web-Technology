package com.nemil.jersey10;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path ("Nemils")
public class NemilResources 
{
	
	NemilRepository repo = new NemilRepository();
	
	@GET
	@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	public List<Nemil> getNemils()
	{
		return repo.getNemils();
	}
	
	@GET
	@Path("Nemil/{id}")
	@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	public Nemil getNemil(@PathParam("id")int id)
	{
		return repo.getNemil(id);
	}    
	
	@POST
	@Path ("Nemil")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	// Creating Nemil resource from client. ( Resource created by POSTMAN)
	public Nemil createNemil(Nemil nem)
	{
		System.out.println(nem);
		repo.create (nem);
		return nem;

	} 
	
	@PUT
	@Path ("Nemil")
	@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	// Updating Nemil resource from client. If it is not in database, create a new resource.
	public Nemil updateNemil(Nemil nem)
	{
		System.out.println(nem);
		
		if ( repo.getNemil((nem.getId())).getId()==0)
		{
			repo.create(nem);
		}
		
		else
		{
			repo.update(nem);
		}
		return nem;
	}  
	
	@DELETE
	@Path("Nemil/{id}")
	//@Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	public Nemil deleteNemil(@PathParam("id")int id)
	{
		Nemil n = repo.getNemil(id);
		if ( repo.getNemil(id).getId()!=0)
		{
			repo.delete(id);
		}
		
		return n;
	}   
}
