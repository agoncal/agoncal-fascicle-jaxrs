package org.agoncal.fascicle.jaxrs.firstlook;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class AuthorResourceTest extends JerseyTest {

  @Override
  protected Application configure() {
    return new ResourceConfig(AuthorResource.class);
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldGetAllAuthors() {
    // tag::adocShouldGetAllAuthors[]
    String response = target("/authors").request().get(String.class);
    assertEquals("Isaac Asimov, Nora Jemisin, Douglas Adams", response);
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  public void shouldGetAnAuthor() {
    // tag::adocShouldGetAuthor[]
    String response = target("/authors/0").request().get(String.class);
    assertEquals("Isaac Asimov", response);
    // end::adocShouldGetAuthor[]
  }

  @Test
  public void shouldNotFindResource() {
    // tag::adocShouldNotFindResource[]
    Response response = target("/dummy").request().get();
    assertEquals(404, response.getStatus());
    // end::adocShouldNotFindResource[]
  }
}
