package org.agoncal.fascicle.jaxrs.exposing.ex07;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Cookie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
  public void shouldCheckGetCustomerWithCookieParamURI() {
    Cookie myCookie = new Cookie("sessionID", "This is my cookie");
    String response = target("/customers/cookie").request().cookie(myCookie).get(String.class);
    assertEquals("This is my cookie from the server", response);
  }

  @Test
  public void shouldEchoUserAgentValue() {
    String response = target("/customers/userAgent").request().header("User-Agent", "test").get(String.class);
    assertTrue(response.startsWith("test"));
  }
}
