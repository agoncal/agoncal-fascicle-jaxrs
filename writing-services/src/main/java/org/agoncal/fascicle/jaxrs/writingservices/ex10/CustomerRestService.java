package org.agoncal.fascicle.jaxrs.writingservices.ex10;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocsnippet[]
@Path("/customers")
public class CustomerRestService {

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
// end::adocsnippet[]
