package com.top.get.service.rest.get;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.top.get.post.GetFeed;
import com.top.get.service.rest.verifyToken.VerifyToken;
import com.top.get.thought.GetFullThought;
import com.top.get.thought.GetThoughts;
import com.top.get.thought.GetUserThoughts;
import com.top.lib.beans.generic.InsertResponseBean;

@Path("/out")
public class TopGetService {
	@GET
	@Path("/test")
	public Response getUser(String json) {
		String u = "<h3>Keep going</h3>";
		return Response.ok(u).build();
	}

	@GET
	@Path("/getfeed")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getFeed(@QueryParam("pagenum") Integer pagenum, @QueryParam("location") String location,
			@QueryParam("dynamic") String dynamic, @QueryParam("categories") String categories) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			List<Map<String, Object>> data = new GetFeed().getFeed(pagenum, location, dynamic, categories);
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@VerifyToken
	@Path("/getthoughts/{postid}/{required}/{existing}")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getThoughtsFeed(@PathParam("postid") Integer postid, @PathParam("existing") Integer existing,
			@PathParam("required") Integer required) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			List<Map<String, Object>> data = new GetThoughts().getThoughts(postid, existing, required);
			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@VerifyToken
	@Path("/getthoughts/{postid}/{required}")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getThoughtsStartFeed(@PathParam("postid") Integer postid, @PathParam("existing") Integer existing,
			@PathParam("required") Integer required) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			List<Map<String, Object>> data = new GetThoughts().getThoughts(postid, existing, required);
			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@Path("/getthoughts/{postid}")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getThoughtsDefaultFeed(@PathParam("postid") Integer postid, @PathParam("existing") Integer existing,
			@PathParam("required") Integer required) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			List<Map<String, Object>> data = new GetThoughts().getThoughts(postid, existing, required);
			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@Path("/getfullthought")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getFullThought(@QueryParam("thoughtid") Integer thoughtid) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			List<Map<String, Object>> data = new GetFullThought().getThought(thoughtid);
			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@Path("/userthoughts/{userid}")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getUserThoughts(@PathParam("userid") Integer userid, @QueryParam("pagenum") Integer pagenum) {
		InsertResponseBean response = new InsertResponseBean();
		try {
			if (null == pagenum || pagenum <= 0)
				pagenum = 1;
			List<Map<String, Object>> data = new GetUserThoughts().getUserThoughts(userid, pagenum);
			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
			response.setData(data);
			response.setCode(0);
			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

	@GET
	@Path("/thoughtscount")
	@Consumes("application/json")
	@Produces("application/json; charset=UTF-8")
	public Response getThoughtsCount(@QueryParam("thoughtid") Integer thoughtid) {
		InsertResponseBean response = new InsertResponseBean();
		try {
//			List<Map<String, Object>> data = new GetUserThoughts().getUserThoughts(thoughtid);
//			// JsonObject jsonObject =new JsonParser().parse(data).getAsJsonObject();
//			response.setData(data);
//			response.setCode(0);
//			response.setMessage("Success!!!");
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(-1);
			response.setMessage("Something went wrong please try agian after sometime");
		}
		return Response.ok(response).build();
	}

//	try{
//		UserBean bean = auth.validateUser(username,password);
//		if(bean !=null) {
//			ResponseBuilder responseBuilder = Response.ok(new Gson().toJson(bean));
//			responseBuilder.header("Authorization", "Bearer "+issueToken(bean));
//			return responseBuilder.build();
//		}
//		else {
//			return Response
//					.status(401)
//					.entity("Please check your credentials")
//					.build(); //status(401, "Please check your credentials").build();
//		}
//	}catch(Exception e) {
//		return Response.serverError().entity("Internal Server Error").build();
//	}

}
