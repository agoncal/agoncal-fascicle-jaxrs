package org.agoncal.fascicle.jaxrs.exposing.ex15;

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
