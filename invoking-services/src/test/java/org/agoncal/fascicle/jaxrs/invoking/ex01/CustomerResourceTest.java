package org.agoncal.fascicle.jaxrs.invoking.ex01;

import org.agoncal.fascicle.jaxrs.invoking.Customer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
public class CustomerResourceTest extends JerseyTest {

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
// tag::adocclient[]
    Client client = ClientBuilder.newClient();
// end::adocclient[]
// tag::adoctarget[]
    WebTarget target = client.target("http://localhost:9998/customers");
// end::adoctarget[]
// tag::adocinvoke[]
    Invocation invocation = target.request().buildGet();
// end::adocinvoke[]
// tag::adocresponse[]
    Response response = invocation.invoke();
// end::adocresponse[]
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldPingURI() throws URISyntaxException {
    Client client = ClientBuilder.newClient();
// tag::adocuri[]
    URI uri = new URI("http://localhost:9998/customers");
    WebTarget target = client.target(uri);
// end::adocuri[]
    Invocation invocation = target.request(MediaType.TEXT_PLAIN).buildGet();
    Response response = invocation.invoke();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldPingCompact() {
// tag::adocompact[]
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://localhost:9998/customers");
    Invocation invocation = target.request(MediaType.TEXT_PLAIN).buildGet();
    Response response = invocation.invoke();
// end::adocompact[]
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldPingOne() {
// tag::adoconeline[]
    Response response = ClientBuilder
      .newClient()
      .target("http://localhost:9998/customers")
      .request(MediaType.TEXT_PLAIN)
      .get();
// end::adoconeline[]
    assertEquals(200, response.getStatus());
  }

  @Test
  @Ignore // TODO
  public void shouldCreateCustomerCustom() {
// tag::adocclientprop[]
    Client client = ClientBuilder.newClient();
    client.property("MyProperty", 1234).register(CustomCustomerWriter.class);
// end::adocclientprop[]
    WebTarget target = client.target("http://localhost:9998/customers");
    Invocation invocation = target.request().buildPost(Entity.entity(new Customer("5678", "John", "Smith"), "custom/format"));
    Response response = invocation.invoke();
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().endsWith("/customer/5678"));
  }
}
