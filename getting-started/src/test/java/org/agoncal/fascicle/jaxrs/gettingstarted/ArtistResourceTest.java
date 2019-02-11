package org.agoncal.fascicle.jaxrs.gettingstarted;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistResourceTest extends JerseyTest {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldListAllArtists() {
    Response response = target("/users").request().get();
    Assertions.assertEquals(200, response.getStatus(), "should return status 200");
    assertNotNull("Should return user list", response.getEntity().toString());
  }}
