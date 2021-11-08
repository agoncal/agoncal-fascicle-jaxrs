package org.agoncal.fascicle.jaxrs.exposing.ex11;

import org.agoncal.fascicle.jaxrs.exposing.Customer;
import org.agoncal.fascicle.jaxrs.exposing.Customers;
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
  public void shouldGetCustomers() {
    Response response = target("/customers").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    Customers customers = response.readEntity(Customers.class);
    assertEquals(2, customers.size());
  }

  @Test
  public void shouldGetCustomer() {
    Response response = target("/customers/1234").request().get();
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    Customer customer = response.readEntity(Customer.class);
    assertEquals("jsmith@gmail.com", customer.getEmail());
    assertEquals("John", customer.getFirstName());
    assertEquals("Smith", customer.getLastName());
  }

  @Test
  public void shouldCreateCustomer() {
    Response response = target("/customers").request().post(Entity.entity(new Customer("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().contains("/customers/1334"));
  }

  @Test
  public void shouldUpdateCustomer() {
    Response response = target("/customers").request().put(Entity.entity(new Customer("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    Customer customer = response.readEntity(Customer.class);
    assertEquals("JohnUpdated", customer.getFirstName());
  }

  @Test
  public void shouldDeleteCustomer() {
    Response response = target("/customers/1234").request().delete();
    assertEquals(204, response.getStatus());
  }
}
