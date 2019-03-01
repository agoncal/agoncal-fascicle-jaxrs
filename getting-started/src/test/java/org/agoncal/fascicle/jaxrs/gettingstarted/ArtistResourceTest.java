package org.agoncal.fascicle.jaxrs.gettingstarted;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistResourceTest /* extends JerseyTest*/ {

  private Name faker = new Faker().name();

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldTestOutofContainer() {
    ArtistResource resource = new ArtistResource();
    assertEquals(new Integer(3), resource.countAll());
    resource.create(new Artist(faker.firstName(), faker.lastName()));
    assertEquals(new Integer(4), resource.countAll());
  }

//  @Test
//  public void shouldListAllArtists() {
//    Response response = target("/users").request().get();
//    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
//    assertNotNull("Should return user list", response.getEntity().toString());
//  }
}
