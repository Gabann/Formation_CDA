package rest_client;

import dto.AuthorDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/author")
@RegisterRestClient(configKey = "author-service")
public interface AuthorServiceClient
{
	@GET
	@Path("/{id}")
	AuthorDto getAuthorById(@PathParam("id") Long id);
}
