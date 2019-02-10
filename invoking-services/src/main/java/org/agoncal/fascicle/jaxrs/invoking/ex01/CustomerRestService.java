package org.agoncal.fascicle.jaxrs.invoking.ex01;

import org.agoncal.fascicle.jaxrs.invoking.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/customers")
public class CustomerRestService {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "ping";
  }

  @POST
  @Consumes("custom/format")
  public Response createCustomerCustom(Customer customer) {
    URI customerURI = UriBuilder.fromResource(CustomerRestService.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }
}
