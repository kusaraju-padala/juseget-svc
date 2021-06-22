package com.top.get.service.rest.get;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/star")
public class TopStarService {
	
	@GET
	@Path("/search")
	public Response searchJuse(@QueryParam("q") String searchString) {
		String u = "<h3>Keep going</h3><h4>"+searchString+"</h4>";
		return Response.ok(u).build();
	}
}
