package org.agoncal.fascicle.jaxrs.gettingstarted;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest extends JerseyTest {

  @BeforeEach
  public  void before() throws Exception {
    super.setUp();
  }

  @AfterEach
  public void after() throws Exception {
    super.tearDown();
  }

  @Override
  protected Application configure() {
    return new ResourceConfig(ArtistResource.class);
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldGetIt() {

    // tag::adocShouldCreateAnAuthor[]
    String responseMsg = target("artists").request().get(String.class);
    assertEquals("Got it!", responseMsg);
    // end::adocShouldCreateAnAuthor[]
  }
}
