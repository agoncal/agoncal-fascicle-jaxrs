package org.agoncal.fascicle.jaxrs.exposing.ex03;

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
public class ItemResourceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(ItemResource.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckGetItemsURI() {
    Response response = target("/items").request().get();
    assertEquals(200, response.getStatus());
  }
}
