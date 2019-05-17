package org.agoncal.fascicle.jaxrs.gettingstarted;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.ws.rs.core.Application;

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
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeEach
  public  void before() throws Exception {
    super.setUp();
  }

  @AfterEach
  public void after() throws Exception {
    super.tearDown();
  }

  // ======================================
  // =              Methods               =
  // ======================================

//  @Test
//  public void shouldListAllArtists() {
//    Response response = target("/users").request().get();
//    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
//    assertNotNull("Should return user list", response.getEntity().toString());
//  }
}
