package ressource;

import entity.Book;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.BookService;

import java.util.List;

@Path("/api/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRessource
{
	@Inject
	BookService service;

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
	public Response create(Book book)
	{
		service.create(book);
		return Response.ok().status(201).build();
	}

	@POST
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateById(Book book, @PathParam("id") Long id)
	{
		boolean success = service.updateById(id, book);
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
	@Path("/notBorrowed")
	public Response getBooksNotBorrowed() {
		List<Book> books = service.getBooksNotBorrowed();
		return Response.ok(books).status(200).build();
	}

	@GET
	@Path("/isBorrowed/{id}")
	public Response isBorrowed(@PathParam("id") Long id) {
		boolean isBorrowed = service.isBookBorrowedById(id);
		return Response.ok(isBorrowed).status(200).build();
	}

	@GET
	@Path("/available")
	public Response getAvailableBooks() {
		List<Book> books = service.getAvailableBooks();
		return Response.ok(books).status(200).build();
	}

	@GET
	@Path("/isbn/{isbn}")
	public Response getByIsbn(@PathParam("isbn") String isbn) {
		return Response.ok(service.getByIsbn(isbn)).status(200).build();
	}
}
