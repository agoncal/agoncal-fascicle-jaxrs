package org.agoncal.fascicle.jaxrs.exposing.ex12;

import org.junit.Test;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class URIBuilderTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildURIs() {
    // tag::adocSnippet[]
    URI uri = UriBuilder.fromUri("http://www.cdbookstore.com").path("book").path("1234").build();
    assertEquals("http://www.cdbookstore.com/book/1234", uri.toString());

    uri = UriBuilder.fromUri("http://www.cdbookstore.com").path("book").queryParam("author", "Goncalves").build();
    assertEquals("http://www.cdbookstore.com/book?author=Goncalves", uri.toString());

    uri = UriBuilder.fromUri("http://www.cdbookstore.com").path("book").matrixParam("author", "Goncalves").build();
    assertEquals("http://www.cdbookstore.com/book;author=Goncalves", uri.toString());

    uri = UriBuilder.fromUri("http://www.cdbookstore.com")
      .path("{path}").queryParam("author", "{value}")
      .build("book", "Goncalves");
    assertEquals("http://www.cdbookstore.com/book?author=Goncalves", uri.toString());

    uri = UriBuilder.fromResource(BookResource.class).path("1234").build();
    assertEquals("/book/1234", uri.toString());

    uri = UriBuilder.fromResource(BookResource.class).host("www.cdbookstore.com").path("book").path("1234").build();
    assertEquals("//www.cdbookstore.com/book/book/1234", uri.toString());

    uri = UriBuilder.fromResource(BookResource.class).host("www.cdbookstore.com").port(8282).path("book").path("1234").build();
    assertEquals("//www.cdbookstore.com:8282/book/book/1234", uri.toString());

    uri = UriBuilder.fromUri("http://www.cdbookstore.com").fragment("book").build();
    assertEquals("http://www.cdbookstore.com/#book", uri.toString());
    // end::adocSnippet[]
  }
}
