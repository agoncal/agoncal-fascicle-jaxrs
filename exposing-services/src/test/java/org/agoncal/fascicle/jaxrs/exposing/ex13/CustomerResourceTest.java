package org.agoncal.fascicle.jaxrs.exposing.ex13;

import org.agoncal.fascicle.jaxrs.exposing.Customer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerResourceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerResource.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void getGetDefaultMediaType() {
    Response response = target("/customers/media").request().get();
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    assertEquals("text/html", response.readEntity(String.class));
  }

  @Test
  public void shouldCreateCustomer() {
    Response response = target("/customers").request().post(Entity.entity(new Customer("1", "John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().contains("/customers/1"));
  }
}
