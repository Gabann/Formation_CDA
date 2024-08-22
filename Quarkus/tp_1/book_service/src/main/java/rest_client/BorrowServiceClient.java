package rest_client;

import dto.AuthorDto;
import entity.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/borrow")
@RegisterRestClient(configKey = "borrow-service")
public interface BorrowServiceClient
{
	@GET
	@Path("/isBookBorrowed/{id}")
	boolean isBookBorrowedById(@PathParam("id") Long id);
}
