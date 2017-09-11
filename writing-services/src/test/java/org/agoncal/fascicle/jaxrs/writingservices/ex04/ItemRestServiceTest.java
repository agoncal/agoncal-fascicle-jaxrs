package org.agoncal.fascicle.jaxrs.writingservices.ex04;

import org.agoncal.fascicle.jaxrs.writingservices.Book;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class ItemRestServiceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(ItemRestService.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckGetItemsURI() {
    Response response = target("/items").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCDsURI() {
    Response response = target("/items/cds").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetBooksURI() {
    Response response = target("/items/books").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckPostBookURI() {
    Response response = target("/items/books").request().post(Entity.entity(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book",
      "1-84023-742-2", 354, false), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
  }
}
