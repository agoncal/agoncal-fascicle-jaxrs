package org.agoncal.fascicle.jaxrs.exposing.ex08;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

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
  public void shouldCheckGetCustomerByZipCodeCityURI() {
    Response response = target("/customers").queryParam("zip", 75011L).queryParam("city", "Lisbon").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByZipCodeAndDefaultCityURI() {
    Response response = target("/customers").queryParam("zip", 75011L).request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameNameAndSurnameURI() {
    Response response = target("/customers/search").matrixParam("firstname", "Antonio2").matrixParam("surname", "Goncalves2").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameAndDefaultSurnameURI() {
    Response response = target("/customers/search").matrixParam("firstname", "AntonioNull").request().get();
    assertEquals(200, response.getStatus());
  }
}
