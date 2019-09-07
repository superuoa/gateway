package com.thorntail.gateway.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;

public class WebClientService {

	private  Client client;
	private  String projectURL = "http://project-service:8080";
	private  String freelancerURL = "http://freelancers-service:8080";
	
	public  Client openClient() {
		
		return ClientBuilder.newClient();
	}
	public  void closeClient(Client c) {
		c.close();
	}
	
	public  Response getProjects() {
		Response response = null;
		try {
			
			client = openClient();
			
			System.out.println("client connetct >>>>>>>>>>>>>. " + client);
			WebTarget target = client.target(projectURL)
					.path("/projects");
	        response = target.request(MediaType.APPLICATION_JSON).get();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public  Response getProject(long projectId) {
		Response response = null;
		try {
			
			client = openClient();
			
			WebTarget target = client.target(projectURL)
					.path("/projects/"+projectId);
	        response = target.request(MediaType.APPLICATION_JSON).get();
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return response;
	}

	public  Response getProjectByStatus(String theStatus) {
		Response response = null;
		try {
			
			client = openClient();
			
			WebTarget target = client.target(projectURL)
					.path("/projects/status/"+theStatus);
	        response = target.request(MediaType.APPLICATION_JSON).get();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public  Response getFreelancers() {
		Response response = null;
		try {
			
			client = openClient();
			
			WebTarget target = client.target(freelancerURL)
					.path("/freelancers");
	        response = target.request(MediaType.APPLICATION_JSON).get();
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return response;
	}

	public  Response getFreelancer(long freelancerId) {
		Response response = null;
		try {
			
			client = openClient();
			
			WebTarget target = client.target(freelancerURL)
					.path("/freelancers/"+freelancerId);
	        response = target.request(MediaType.APPLICATION_JSON).get();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
	
	
	
	
}
