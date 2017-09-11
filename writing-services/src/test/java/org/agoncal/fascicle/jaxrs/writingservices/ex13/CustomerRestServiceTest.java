package org.agoncal.fascicle.jaxrs.writingservices.ex13;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerRestServiceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerRestService.class);
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
