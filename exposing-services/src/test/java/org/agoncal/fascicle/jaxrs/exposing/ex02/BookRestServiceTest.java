package org.agoncal.fascicle.jaxrs.exposing.ex02;

import org.agoncal.fascicle.jaxrs.exposing.Book;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookRestServiceTest extends JerseyTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book>";

  // ======================================
  // =        Overridden Methods          =
  // ======================================

  @Override
  protected Application configure() {
    return new ResourceConfig(BookRestService.class);
  }
  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test @Ignore("TODO get rid of JPA, JTA and do JSON")
  public void shouldCreateABook() throws JAXBException {
    // given
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // when
    Response response = target("/books").request().post(Entity.entity(book, "application/xml"));

    // then
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().startsWith("http://localhost:8080/chapter15-samples-1.0/rs/04/books"));

    // when
    response = target(response.getLocation().toString()).request(MediaType.APPLICATION_XML).get();

    // then
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());

    System.out.println("########## " + response.getEntity());

    book = response.readEntity(Book.class);
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getTitle());
    assertEquals("Science fiction comedy book", book.getDescription());
  }
}
