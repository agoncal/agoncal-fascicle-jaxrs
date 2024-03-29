package org.agoncal.fascicle.jaxrs.gettingstarted;

import com.jayway.jsonpath.JsonPath;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
  @Order(1)
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
  @Order(2)
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
  @Order(3)
  public void shouldCountArtist() {
    // tag::shouldCountArtist[]
    Response response = target("/artists/count").request().get();
    assertEquals(200, response.getStatus());
    // end::shouldCountArtist[]
  }

  @Test
  @Order(4)
  public void shouldCreateArtist() {
    // tag::adocShouldCreateArtist[]
    Integer nbArtists = target("/artists/count").request().get(Integer.class);
    Artist artist = new Artist().firstName("George").lastName("Martin");
    Response response = target("/artists").request().post(Entity.json(artist));
    assertEquals(201, response.getStatus());
    assertEquals(new Integer(nbArtists + 1), target("/artists/count").request().get(Integer.class));
    // end::adocShouldCreateArtist[]
  }

//  @Test
//  @Order(5)
//  public void shouldCountArtistAfterCreate() {
//    given().
//    when().
//      get("/artists/count").
//    then().
//      assertThat().
//        statusCode(is(200)).
//      and().
//        body(is("5"));
//  }


  @Test
  @Order(6)
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

//  @Test
//  @Order(7)
//  public void shouldCountArtistAfterDelete() {
//    given().
//    when().
//      get("/artists/count").
//    then().
//      assertThat().
//        statusCode(is(200)).
//      and().
//        body(is("4"));
//  }
}
