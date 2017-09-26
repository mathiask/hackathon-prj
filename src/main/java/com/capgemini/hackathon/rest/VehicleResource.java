package com.capgemini.hackathon.rest;

import com.capgemini.hackathon.entity.VehicelBE;
import com.capgemini.hackathon.tech.logging.Log;
import com.capgemini.hackathon.tech.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("/vehicle")
public class VehicleResource {

	private static final Log LOG = LogFactory.getLog();

	@PersistenceContext
	EntityManager em;


	@Path("{id}")
	@Produces("text/plain")
	public VehicelBE findVehicle(@PathParam("id") String vin) {
		return em.find(VehicelBE.class, vin);
	}


}
