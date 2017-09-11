package org.agoncal.fascicle.jaxrs.writingservices.ex09;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;

import javax.ws.rs.*;
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
  @Produces(MediaType.TEXT_PLAIN)
  public Response getAsPlainText() {
    // ...
    // tag::adocskip1[]
    return Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565").toString()).build();
    // end::adocskip1[]
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Response getAsHtml() {
    // ...
    // tag::adocskip2[]
    final StringBuilder sb = new StringBuilder();
    sb.append("<h1>Customer</h1><p>");
    sb.append(new Customer("John", "Smith", "jsmith@gmail.com", "1234565").toString());
    sb.append("</p><hr/>");
    return Response.ok(sb.toString()).build();
    // end::adocskip2[]
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response getAsJsonAndXML() {
    // ...
    // tag::adocskip3[]
    return Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565")).build();
    // end::adocskip3[]
  }

  @PUT
  @Consumes(MediaType.TEXT_PLAIN)
  public void putName(String customer) {
    // ...
  }
}
// end::adocsnippet[]
