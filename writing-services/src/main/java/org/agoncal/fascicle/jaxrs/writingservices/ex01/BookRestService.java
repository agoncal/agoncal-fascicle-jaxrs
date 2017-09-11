package org.agoncal.fascicle.jaxrs.writingservices.ex01;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Path("/book")
public class BookRestService {

  @GET
  @Produces("text/plain")
  public String getBookTitle() {
    return "H2G2";
  }
}
// end::adocsnippet[]
