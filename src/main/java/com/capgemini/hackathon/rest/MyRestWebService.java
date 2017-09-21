package com.capgemini.hackathon.rest;

import com.capgemini.hackathon.tech.logging.Log;
import com.capgemini.hackathon.tech.logging.LogFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/myRestWebService")
public class MyRestWebService {

	private static final Log LOG = LogFactory.getLog();

	@Path("/log")
	@GET
	@Produces("text/plain")
	public String logMe() {
		LOG.info("Logging");
		return "TEST";
	}
}
