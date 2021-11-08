package org.agoncal.fascicle.jaxrs.exposing.ex09;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerResourceTest extends JerseyTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String CUSTOMER_TEXT = "Customer{id='null', firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}";
  public static final String CUSTOMER_HTML = "<h1>Customer</h1><p>Customer{id='null', firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}</p><hr/>";
  public static final String CUSTOMER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer>";
  public static final String CUSTOMER_JSON = "{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}";

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerResource.class, MOXyJsonProvider.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetCustomerAsPlainText() {
    Response response = target("/customers").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_TEXT, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsHTML() {
    Response response = target("/customers").request(MediaType.TEXT_HTML).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_HTML, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsXML() {
    Response response = target("/customers").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_XML, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsJSON() {
    Response response = target("/customers").request(MediaType.APPLICATION_JSON).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_JSON, response.readEntity(String.class));
  }
}
