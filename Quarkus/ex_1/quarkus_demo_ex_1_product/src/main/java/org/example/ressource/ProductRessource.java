package org.example.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Product;
import org.example.service.ProductService;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductRessource
{
	@Inject
	ProductService service;

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
	public Response create(Product product)
	{
		service.create(product);
		return Response.ok().status(201).build();
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateById(Product product, @PathParam("id") Long id)
	{
		boolean success = service.updateById(id, product);
		if (success)
		{
			return Response.ok().status(200).build();
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
