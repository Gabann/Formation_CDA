package ressource;

import entity.Review;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.ReviewService;

@Path("/api/review")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewRessource
{
	@Inject
	ReviewService service;

	@GET
	public Response getAll()
	{
		return Response.ok(service.getAll()).status(200).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id)
	{
		return Response.ok(service.getById(id)).status(200).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") Long id)
	{
		boolean success = service.deleteById(id);
		if (success)
		{
			return Response.ok().status(200).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Review review)
	{
		service.create(review);
		return Response.ok().status(201).build();
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateById(Review review, @PathParam("id") Long id)
	{
		boolean success = service.updateById(id, review);
		if (success)
		{
			return Response.ok().status(200).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/score/{score}")
	public Response getByScore(@PathParam("score") int score)
	{
		return Response.ok(service.getByScore(score)).status(200).build();
	}

	@GET
	@Path("/user/{userId}")
	public Response getByUserId(@PathParam("userId") Long userId)
	{
		return Response.ok(service.getByUserId(userId)).status(200).build();
	}

	@GET
	@Path("/isbn/{isbn}")
	public Response getByBookIsbn(@PathParam("isbn") String isbn)
	{
		return Response.ok(service.getByBookIsbn(isbn)).status(200).build();
	}
}
