package org.agoncal.fascicle.jaxrs.writingservices.ex10;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerRestServiceTest extends JerseyTest {

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(CustomerRestService.class, MOXyJsonProvider.class);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGetAsPlainText() {
    Response response = target("/customers").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals("Customer{id=null, firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}", response.readEntity(String.class));
  }

  @Test
  public void shouldGetMaximumBonusAllowed() {
    Response response = target("/customers/max").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals((Object) 1234L, response.readEntity(Long.class));
  }

  @Test
  public void shouldGetStringAsXML() {
    Response response = target("/customers").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer>", response.readEntity(String.class));
  }

  @Test
  public void shouldGetAsJSon() {
    Response response = target("/customers").request(MediaType.APPLICATION_JSON).get();
    assertEquals(200, response.getStatus());
    assertEquals("{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}", response.readEntity(String.class));
  }

  @Test
  public void shouldCheckResponse() {
    // tag::adocsnippet[]
    Response.ok().build();
    Response.ok().cookie(new NewCookie("SessionID", "5G79GDIFY09")).build();
    Response.ok("Plain Text").expires(new Date()).build();
    Response.ok(new Customer("John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_JSON).build();
    Response.noContent().build();
    Response.accepted(new Customer("John", "Smith", "jsmith@gmail.com", "1234565")).build();
    Response.notModified().header("User-Agent", "Mozilla").build();
    // end::adocsnippet[]
  }
}
