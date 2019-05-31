package org.agoncal.fascicle.jaxrs.gettingstarted;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * RunServer class.
 */
public class RunServer {

  private static final String BASE_URI = "http://localhost:8080/cdbookstore/";

  public static void main(String[] args) throws IOException {
    ResourceConfig rc = new ResourceConfig().packages("org.agoncal.fascicle.jaxrs.gettingstarted");
    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    System.out.println("JAX-RS application started at " + BASE_URI);
    System.in.read();
    server.shutdown();
  }
}

