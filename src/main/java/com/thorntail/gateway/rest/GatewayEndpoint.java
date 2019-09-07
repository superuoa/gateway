package com.thorntail.gateway.rest;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.thorntail.gateway.service.WebClientService;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


@Path("/gateway")
public class GatewayEndpoint {

	@GET
	@Produces("application/json")
	@Path("/projects")
	public Response doGetProjects() {
		WebClientService w = new WebClientService();
		
		Response response = w.getProjects();

		System.out.println("response status >>>>>>> "+response.getStatus());
	
		return Response.ok(response.readEntity(String.class)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/projects/{projectId}")
	public Response doGetProject(@PathParam("projectId") long projectId) {
		WebClientService w = new WebClientService();
		
		Response response = w.getProject(projectId);

		return Response.ok(response.readEntity(String.class)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/projects/status/{theStatus}")
	public Response doGetProjectByStatus(@PathParam("theStatus") String theStatus) {
		WebClientService w = new WebClientService();
		
		Response response = w.getProjectByStatus(theStatus);

		return Response.ok(response.readEntity(String.class)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/freelancers")
	public Response doGetFreelancers() {
		WebClientService w = new WebClientService();
		
		Response response = w.getFreelancers();

		return Response.ok(response.readEntity(String.class)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/freelancers/{freelancerId}")
	public Response doGetFreelancer(@PathParam("freelancerId") long freelancerId) {
		WebClientService w = new WebClientService();
		
		Response response = w.getFreelancer(freelancerId);

		return Response.ok(response.readEntity(String.class)).build();
	}
	
	@GET
	@Produces("application/json")
	@Path("/test")
	public Response doGetTest() {
		String status = "{\"status\":\"OK\"}";
		return Response.ok(status).build();
	}
	
}
