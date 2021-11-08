package org.agoncal.fascicle.jaxrs.invoking.ex02;

import org.agoncal.fascicle.jaxrs.invoking.Book;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
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
  public void shouldGetTextPlain() {
    Response response = target("/books").request().get();
// tag::adocresponse[]
    assertTrue(response.getStatus() == OK.getStatusCode());
    assertTrue(response.getLength() == 4);
    assertTrue(response.getDate() != null);
    assertTrue(response.getHeaderString("Content-type").equals("text/plain"));
// end::adocresponse[]
// tag::adocreadstring[]
    String body = response.readEntity(String.class);
// end::adocreadstring[]
    assertEquals("H2G2", body);
  }

  @Test
  public void shouldGetString() {
// tag::adocreadstr[]
    Response response = ClientBuilder.newClient().target("http://localhost:9998/books").request().get();
    String body = response.readEntity(String.class);
// end::adocreadstr[]
    assertEquals(OK.getStatusCode(), response.getStatus());
    assertEquals("H2G2", body);
  }

  @Test
  public void shouldGetStringOne() {
// tag::adocreadstrone[]
    String body = ClientBuilder.newClient().target("http://localhost:9998/books").request().get(String.class);
// end::adocreadstrone[]
    assertEquals("H2G2", body);
  }

  @Test
  public void shouldGetBook() {
    Response response = target("/books").request(MediaType.APPLICATION_XML).get();
    assertEquals(OK.getStatusCode(), response.getStatus());
    assertEquals("application/xml", response.getHeaderString("Content-type"));
// tag::adocreadbook[]
    Book body = response.readEntity(Book.class);
// end::adocreadbook[]
    assertEquals("The Hitchhiker's Guide to the Galaxy", body.getTitle());
  }
}
