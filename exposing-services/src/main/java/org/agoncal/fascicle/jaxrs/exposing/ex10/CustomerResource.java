package org.agoncal.fascicle.jaxrs.exposing.ex10;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  @GET
  public String getAsPlainText() {
    return new Customer("John", "Smith").toString();
  }

  @GET
  @Path("max")
  public Long getMaximumBonusAllowed() {
    return 1234L;
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Customer getAsXML() {
    return new Customer("John", "Smith");
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAsJson() {
    return Response.ok(new Customer("John", "Smith"), MediaType.APPLICATION_JSON).build();
  }
}
// end::adocSnippet[]
