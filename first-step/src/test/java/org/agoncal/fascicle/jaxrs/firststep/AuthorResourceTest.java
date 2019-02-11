package org.agoncal.fascicle.jaxrs.firststep;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;

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
  @BeforeAll
  static void init() {
  }

  @AfterAll
  static void close() {
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCountAuthors() {
    int response = target("/count").request().get(int.class);
    Assertions.assertEquals(3, response);
  }

}
