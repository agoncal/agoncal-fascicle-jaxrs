package org.agoncal.fascicle.jaxrs.exposing.ex15;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  public void getGetInvalidCustomerID() {
    Response response = target("/customers/123").request().get();
    assertEquals(500, response.getStatus());
  }

  @Test
  public void getGetNullCustomer() {
    Response response = target("/customers/123456").request().get();
    assertEquals(404, response.getStatus());
  }
}
