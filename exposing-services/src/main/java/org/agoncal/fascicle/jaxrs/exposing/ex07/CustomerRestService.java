package org.agoncal.fascicle.jaxrs.exposing.ex07;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/customers")
public class CustomerRestService {

  @GET
  @Path("cookie")
  public String extractSessionID(@CookieParam("sessionID") String sessionID) {
    // tag::adocSkip1[]
    System.out.println("extractSessionID : " + sessionID);
    return sessionID + " from the server";
    // end::adocSkip1[]
  }

  @GET
  @Path("userAgent")
  public String extractUserAgent(@HeaderParam("User-Agent") String userAgent) {
    // tag::adocSkip2[]
    System.out.println("echoUserAgent : " + userAgent);
    return userAgent + " from the server";
    // end::adocSkip2[]
  }
}
// end::adocSnippet[]
