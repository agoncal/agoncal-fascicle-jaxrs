package org.agoncal.fascicle.jaxrs.firststep;

import org.agoncal.fascicle.jaxrs.firststep.AuthorResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class AuthorResourceTest extends JerseyTest {

  @Override
  protected Application configure() {
    return new ResourceConfig(AuthorResource.class);
  }
  // end::adocBegin[]

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeEach
  public  void before() throws Exception {
    super.setUp();
  }

  @AfterEach
  public void after() throws Exception {
    super.tearDown();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldGetAllAuthors() {
    // tag::adocShouldGetAllAuthors[]
    String response = target("/authors").request().get(String.class);
    assertEquals("Isaac Asimov, Ray Bradbury, Douglas Adams", response);
    // end::adocShouldGetAllAuthors[]
  }

  @Test
  void shouldGetAuthor() {
    // tag::adocShouldGetAuthor[]
    String response = target("/authors/0").request().get(String.class);
    assertEquals("Isaac Asimov", response);
    // end::adocShouldGetAuthor[]
  }

  @Test
  void shouldNotFindResource() {
    // tag::adocShouldNotFindResource[]
    Response response = target("/dummy").request().get();
    assertEquals(404, response.getStatus());
    // end::adocShouldNotFindResource[]
  }
}
