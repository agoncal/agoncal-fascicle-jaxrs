package org.agoncal.fascicle.jaxrs.exposing.ex01;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class BookResourceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(BookResource.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckResponse() {
    Response response = target("/book").request().get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    String entity = response.readEntity(String.class);
    assertEquals("H2G2", entity);
    assertEquals(4, entity.length(), "H2G2 is 4 characters");
  }

  @Test
  public void shouldCheckForMediaType() {
    Response response = target("/book").request(MediaType.TEXT_PLAIN).get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
  }

  @Test
  public void shouldCheckForWrongMediaType() {
    Response response = target("/book").request(MediaType.APPLICATION_OCTET_STREAM).get();
    assertEquals(Response.Status.NOT_ACCEPTABLE.getStatusCode(), response.getStatus());
  }

  @Test
  public void shouldCheckForWrongURI() {
    Response response = target("/dummy").request().get();
    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
  }
}
