package org.agoncal.fascicle.jaxrs.gettingstarted;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/artists")
public class ArtistResource {

  private Name faker = new Faker().name();

  private List<Artist> artists = Arrays.asList(
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName()),
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName()),
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName())
  );

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(Artist user) {
    // Add artist logic here
    UUID id = UUID.randomUUID();
    artists. add(new Artist(id, faker.firstName(), faker.lastName()));
    return Response.status(Response.Status.CREATED).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Artist> listAll() {
    return artists;
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public Integer countAll() {
    return artists.size();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") UUID id) {
    //artists.removeIf(x -> artists.contains())
    // Delete artist logic here
    return Response.status(Response.Status.NO_CONTENT).entity("Artist deleted successfully !!").build();
  }
}
// end::adocSnippet[]
