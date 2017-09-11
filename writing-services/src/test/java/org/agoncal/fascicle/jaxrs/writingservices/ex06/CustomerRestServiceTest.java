package org.agoncal.fascicle.jaxrs.writingservices.ex06;

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
  public void shouldCheckGetCustomerByZipCodeCityURI() {
    Response response = target("/customers").queryParam("zip", 75011L).queryParam("city", "Lisbon").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameNameURI() {
    Response response = target("/customers/search;firstname=Antonio;surname=Goncalves").request().get();
    assertEquals(200, response.getStatus());
  }
}
