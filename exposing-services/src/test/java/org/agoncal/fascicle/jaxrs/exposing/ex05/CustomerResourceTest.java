package org.agoncal.fascicle.jaxrs.exposing.ex05;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
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
  public void shouldCheckSearchCustomerURI() {
    Response response = target("/customers/search/smith").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByLoginURI() {
    Response response = target("/customers/foobarsmith").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByIdURI() {
    Response response = target("/customers/12345").request().get();
    assertEquals(200, response.getStatus());
  }
}
