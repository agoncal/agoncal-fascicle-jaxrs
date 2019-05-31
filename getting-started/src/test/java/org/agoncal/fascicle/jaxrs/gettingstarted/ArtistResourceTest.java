package org.agoncal.fascicle.jaxrs.gettingstarted;

import com.jayway.jsonpath.JsonPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistResourceTest extends JerseyTest {

  @Override
  protected Application configure() {
    return new ResourceConfig(ArtistResource.class);
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldGetAllArtists() {
    // tag::adocShouldGetAllArtists[]
    Response response = target("/artists").request().get();
    assertEquals(200, response.getStatus());
    String artists = response.readEntity(String.class);
    assertEquals("John", JsonPath.parse(artists).read("$.[0].firstName"));
    assertEquals("Lennon", JsonPath.parse(artists).read("$.[0].lastName"));
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  public void shouldGetArtist() {
    // tag::adocShouldGetArtist[]
    String artists = target("/artists").request().get(String.class);
    String id = JsonPath.parse(artists).read("$.[0].id");
    Response response = target("/artists").path(id).request().get();
    assertEquals(200, response.getStatus());
    String artist = response.readEntity(String.class);
    assertEquals("John", JsonPath.parse(artist).read("$.firstName"));
    assertEquals("Lennon", JsonPath.parse(artist).read("$.lastName"));
    // end::adocShouldGetArtist[]
  }

  @Test
  public void shouldCountArtist() {
    // tag::shouldCountArtist[]
    Response response = target("/artists/count").request().get();
    assertEquals(200, response.getStatus());
    // end::shouldCountArtist[]
  }

  @Test
  public void shouldCreateArtist() {
    // tag::adocShouldCreateArtist[]
    Integer nbArtists = target("/artists/count").request().get(Integer.class);
    Artist artist = new Artist().firstName("George").lastName("Martin");
    Response response = target("/artists").request().post(Entity.json(artist));
    assertEquals(201, response.getStatus());
    assertEquals(new Integer(nbArtists + 1), target("/artists/count").request().get(Integer.class));
    // end::adocShouldCreateArtist[]
  }

  @Test
  public void shouldDeleteArtist() {
    // tag::adocShouldDeleteArtist[]
    Integer nbArtists = target("/artists/count").request().get(Integer.class);
    String artists = target("/artists").request().get(String.class);
    String id = JsonPath.parse(artists).read("$.[0].id");
    Response response = target("/artists").path(id).request().delete();
    assertEquals(204, response.getStatus());
    assertEquals(new Integer(nbArtists - 1), target("/artists/count").request().get(Integer.class));
    // end::adocShouldDeleteArtist[]
  }
}
