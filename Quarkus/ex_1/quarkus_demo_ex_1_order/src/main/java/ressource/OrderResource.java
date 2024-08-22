package ressource;

import entity.Order;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.OrderService;

@Path("/api/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource
{
	@Inject
	OrderService service;

	@GET
	public Response getAll()
	{
		return Response.ok(service.getAllOrders()).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id)
	{
		return Response.ok(service.getOrderById(id)).build();
	}

	@POST
	public Response create(Order order)
	{
		return Response.ok(service.createOrder(order)).status(201).build();
	}
}
