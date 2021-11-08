package org.agoncal.fascicle.jaxrs.exposing.ex13;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  @Context
  UriInfo uriInfo;

  @GET
  @Path("media")
  public String getDefaultMediaType(@Context HttpHeaders headers) {
    List<MediaType> mediaTypes = headers.getAcceptableMediaTypes();
    return mediaTypes.get(0).toString();
  }

  @GET
  @Path("language")
  public String getDefaultLanguage(@Context HttpHeaders headers) {
    List<String> mediaTypes = headers.getRequestHeader(HttpHeaders.ACCEPT_LANGUAGE);
    return mediaTypes.get(0);
  }

  @POST
  public Response createCustomer(Customer cust) {
    Customer customer = customerService.persist(cust);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
    return Response.created(bookUri).build();
  }
  // tag::adocSkip[]
  private CustomerService customerService = new CustomerService();
  private class CustomerService {
    public Customer persist(Customer customer) {
      return new Customer("1", "John", "Smith", "jsmith@gmail.com", "1234565");
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
