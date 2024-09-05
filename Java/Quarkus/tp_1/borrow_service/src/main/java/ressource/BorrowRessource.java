package ressource;

import entity.Borrow;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.BorrowService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("/api/borrow")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BorrowRessource
{
	@Inject
	BorrowService service;

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
	public Response create(Borrow borrow)
	{
		service.create(borrow);
		return Response.ok().status(201).build();
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateById(Borrow borrow, @PathParam("id") Long id)
	{
		boolean success = service.updateById(id, borrow);
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
	@Path("/current")
	public Response getCurrentBorrows()
	{
		return Response.ok(service.getCurrentBorrows()).status(200).build();
	}

	@GET
	@Path("/betweenDates")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getBorrowsBetweenDates(@QueryParam("startDate") String startDateStr, @QueryParam("endDate") String endDateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(startDateStr, formatter);
		LocalDate endDate = LocalDate.parse(endDateStr, formatter);
		return Response.ok(service.getBorrowsBetweenDates(startDate, endDate)).status(200).build();
	}

	@GET
	@Path("/byUserId/{userId}")
	public Response getBorrowsByUserId(@PathParam("userId") Long userId)
	{
		return Response.ok(service.getBorrowsByUserId(userId)).status(200).build();
	}

	@GET
	@Path("/isBookBorrowed/{bookId}")
	public Response isBookBorrowed(@PathParam("bookId") Long bookId)
	{
		return Response.ok(service.isBookBorrowed(bookId)).status(200).build();
	}
}
