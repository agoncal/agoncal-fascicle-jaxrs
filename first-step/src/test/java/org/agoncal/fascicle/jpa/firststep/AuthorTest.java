package org.agoncal.fascicle.jpa.firststep;

import org.agoncal.fascicle.jaxrs.firststep.AuthorResource;
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
public class AuthorTest extends JerseyTest {

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
    return new ResourceConfig(AuthorResource.class);
  }
//  static void init() {
//    // start the server
//    server = Main.startServer();
//    // create the client
//    Client c = ClientBuilder.newClient();
//
//    // uncomment the following line if you want to enable
//    // support for JSON in the client (you also have to uncomment
//    // dependency on jersey-media-json module in pom.xml and Main.startServer())
//    // --
//    // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());
//
//    target = c.target(Main.BASE_URI);
//  }

//  static void close() {
//    server.shutdown();
//  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldGetIt() {

    // tag::adocShouldCreateAnAuthor[]
    String responseMsg = target("/authors").request().get(String.class);
    assertEquals("Got it!", responseMsg);
    // end::adocShouldCreateAnAuthor[]
  }
}
