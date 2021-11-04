package org.agoncal.fascicle.jaxrs.exposing.ex14;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

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
public class CustomerResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("ping")
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "ping";
  }

  @GET
  @Path("{customerId}")
  @Produces(MediaType.APPLICATION_XML)
  public Customer getCustomerXML(@PathParam("customerId") String id) {
    return new Customer(id, "John", "Smith");
  }

  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public Response createCustomerXML(Customer customer) {
    URI customerURI = UriBuilder.fromResource(CustomerResource.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }

  @GET
  @Path("{customerId}")
  @Produces("custom/format")
  public Customer getCustomerCustom(@PathParam("customerId") String id) {
    return new Customer(id, "John", "Smith");
  }

  @POST
  @Consumes("custom/format")
  public Response createCustomerCustom(Customer customer) {
    URI customerURI = UriBuilder.fromResource(CustomerResource.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }
}
