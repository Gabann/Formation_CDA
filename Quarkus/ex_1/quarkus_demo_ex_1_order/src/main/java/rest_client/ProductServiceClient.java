package rest_client;


import dto.ProductDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/products")
@RegisterRestClient(configKey = "product-service")
public interface ProductServiceClient {

    @GET
    @Path("/{id}")
    ProductDto getProductById(@PathParam("id") Long id);


}
