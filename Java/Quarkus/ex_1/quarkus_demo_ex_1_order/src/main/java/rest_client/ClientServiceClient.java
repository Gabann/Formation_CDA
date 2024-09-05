package rest_client;


import dto.ClientDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/clients")
@RegisterRestClient(configKey = "client-service")
public interface ClientServiceClient {

    @GET
    @Path("/{id}")
    ClientDto getClientById(@PathParam("id") Long id);


}
