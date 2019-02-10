package org.agoncal.fascicle.jaxrs.gettingstarted;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

// tag::adocSnippet[]
@Path("/artists")
public class ArtistEndpoint {

  @POST
  public Response create(Artist user) {
    // Add artist logic here
    return Response.status(Response.Status.CREATED).build();
  }

  @GET
  public List<Artist> listAll() {
    List<Artist> artists = new ArrayList<>();
    artists.add(new Artist(1L, "A", "demo@gmail.com"));
    artists.add(new Artist(2L, "B", "demo1@gmail.com"));
    artists.add(new Artist(3L, "C", "demo2@gmail.com"));
    return artists;
  }

  @GET
  @Path("/count")
  public Integer countAll() {
    return 3;
  }

  @DELETE
  @Path("/user/{id}")
  public Response delete(@PathParam("id") long id) {
    // Delete artist logic here
    return Response.status(Response.Status.NO_CONTENT).entity("Artist deleted successfully !!").build();
  }
}
// end::adocSnippet[]
