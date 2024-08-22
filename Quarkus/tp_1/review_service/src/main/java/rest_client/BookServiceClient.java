package rest_client;

import dto.BookDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/book")
@RegisterRestClient(configKey = "book-service")
public interface BookServiceClient
{
	@GET
	@Path("/{id}")
	BookDto getBookById(@PathParam("id") Long id);

	@GET
	@Path("/isbn/{isbn}")
	BookDto getBookByIsbn(@PathParam("isbn") String isbn);
}
