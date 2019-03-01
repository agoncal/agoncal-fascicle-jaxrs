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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {

  private Name faker = new Faker().name();

  private ArrayList<Artist> artists = new ArrayList<>(Arrays.asList(
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName()),
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName()),
    new Artist(UUID.randomUUID(), faker.firstName(), faker.lastName())
  ));

  @POST
  public Response create(@Context UriInfo uriInfo, Artist artist) {
    artist.setId(UUID.randomUUID());
    artists.add(artist);
    URI uri = uriInfo.getAbsolutePathBuilder().path(artist.getId().toString()).build();
    return Response.created(uri).build();
  }

  @GET
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
    artists.removeIf(x -> artists.contains(new Artist(id)));
    return Response.noContent().build();
  }
}
// end::adocSnippet[]
