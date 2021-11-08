package org.agoncal.fascicle.jaxrs.exposing.ex14;

import org.agoncal.fascicle.jaxrs.exposing.Customer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerResourceTest extends JerseyTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><firstName>John</firstName><id>1234</id><lastName>Smith</lastName></customer>";
  public static final String CUSTOM = "1234/John/Smith";

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerResource.class, CustomCustomerWriter.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldPing() {
    assertEquals("ping", target("/customers/ping").request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void shouldGetCustomerAsXML() {
    Response response = target("/customers/1234").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals(XML, response.readEntity(String.class));
  }

  @Test
  public void shouldCreateCustomerXML() {
    Response response = target("/customers").request().post(Entity.xml(new Customer("1234", "John", "Smith")));
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().contains("/customers/1234"));
  }

  @Test
  public void shouldGetCustomerAsCustom() {
    Response response = target("/customers/1234").request("custom/format").get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOM, response.readEntity(String.class));
  }


  @Test @Ignore // TODO
  public void shouldCreateCustomerCustom() {
    client().register(CustomCustomerWriter.class);
    Response response = target("/customers").request().post(Entity.entity(new Customer("5678", "John", "Smith"), "custom/format"));
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().endsWith("/customer/5678"));
  }
}
