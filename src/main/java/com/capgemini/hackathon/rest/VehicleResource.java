package com.capgemini.hackathon.rest;

import com.capgemini.hackathon.entity.VinBE;
import com.capgemini.hackathon.tech.logging.Log;
import com.capgemini.hackathon.tech.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/vehicle")
public class VehicleResource {

	private static final Log LOG = LogFactory.getLog();

	@PersistenceContext
	EntityManager em;


	@Path("id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public VinBE findVehicle(@PathParam("id") int id) {
		return em.find(VinBE.class, id);
	}

	@Path("vin/{vin}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VinBE> findVehicle(@PathParam("vin") String vin) {
		return em.createQuery("select vinBE from VinBE vinBE where vinBE.vin=:vinParam")
				.setParameter("vinParam", vin).getResultList();
	}

}
