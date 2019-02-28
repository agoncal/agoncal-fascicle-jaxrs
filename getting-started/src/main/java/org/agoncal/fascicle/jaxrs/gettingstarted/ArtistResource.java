package org.agoncal.fascicle.jaxrs.gettingstarted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// @formatter:off
// tag::adocSnippet[]
@Path("artists")
public class ArtistResource {

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  /**
   * Method handling HTTP GET requests. The returned object will be sent
   * to the client as "text/plain" media type.
   *
   * @return String that will be returned as a text/plain response.
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getIt() {
    return "Got it!";
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
