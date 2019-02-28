package org.agoncal.fascicle.jaxrs.gettingstarted;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocBegin[]
public class ArtistTest {

  private static HttpServer server;
  private static WebTarget target;

  @BeforeAll
  static void init() {
    // start the server
    server = Main.startServer();
    // create the client
    Client c = ClientBuilder.newClient();

    // uncomment the following line if you want to enable
    // support for JSON in the client (you also have to uncomment
    // dependency on jersey-media-json module in pom.xml and Main.startServer())
    // --
    // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

    target = c.target(Main.BASE_URI);
  }

  @AfterAll
  static void close() {
    server.shutdown();
  }
  // end::adocBegin[]

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  void shouldGetIt() {

    // tag::adocShouldCreateAnAuthor[]
    String responseMsg = target.path("artists").request().get(String.class);
    assertEquals("Got it!", responseMsg);
    // end::adocShouldCreateAnAuthor[]
  }
}
