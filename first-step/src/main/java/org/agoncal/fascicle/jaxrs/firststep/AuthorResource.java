package org.agoncal.fascicle.jaxrs.firststep;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

// tag::adocSnippet[]
@Path("/authors")
public class AuthorResource {

  @GET
  public List<String> getAllAuthors() {
    return Arrays.asList("Isaac Asimov", "Ray Bradbury", "Jules Verne");
  }

  @GET
  @Path("/count")
  public Integer countAuthors() {
    return 3;
  }

}
// end::adocSnippet[]
