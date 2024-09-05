package rest_client;


import dto.UserDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/user")
@RegisterRestClient(configKey = "user-service")
public interface UserServiceClient
{
    @GET
    @Path("/{id}")
    UserDto getUserById(@PathParam("id") Long id);
}
