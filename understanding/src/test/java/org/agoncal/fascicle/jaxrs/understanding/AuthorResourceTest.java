package org.agoncal.fascicle.jaxrs.understanding;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class AuthorResourceTest extends JerseyTest {

  @Override
  protected Application configure() {
    return new ResourceConfig(AuthorResource.class);
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldGetAllAuthors() {
    String response = target("/authors").request().get(String.class);
    assertEquals("Isaac Asimov, Ray Bradbury, Douglas Adams", response);
  }

  @Test
  public void shouldGetAuthor() {
    String response = target("/authors/0").request().get(String.class);
    assertEquals("Isaac Asimov", response);
  }

  @Test
  public void shouldNotFindResource() {
    Response response = target("/dummy").request().get();
    assertEquals(404, response.getStatus());
  }
}
