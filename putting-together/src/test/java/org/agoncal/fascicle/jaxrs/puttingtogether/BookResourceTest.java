package org.agoncal.fascicle.jaxrs.puttingtogether;

import org.glassfish.jersey.test.JerseyTest;

import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class BookResourceTest extends JerseyTest {

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book>";

  @Test
  public void shouldMarshallABook() throws JAXBException {
    // given
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // then
    assertEquals(XML, writer.toString());
  }

  @Test
  public void shouldMarshallAListOfBooks() throws JAXBException {
    Books books = new Books();
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Books.class);
    Marshaller m = context.createMarshaller();
    m.marshal(books, writer);
  }


  @Test
  public void shouldCreateAndDeleteABook() throws JAXBException {

    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);

    // POSTs a Book
    Response response = target("/books").request().post(Entity.entity(book, MediaType.APPLICATION_XML));
    assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatusInfo().getStatusCode());
    URI bookURI = response.getLocation();

    // With the location, GETs the Book
    response = target(bookURI.toString()).request().get();
    book = response.readEntity(Book.class);
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getTitle());

    // Gets the book id and DELETEs it
    String bookId = bookURI.toString().split("/")[6];
    response = target("/books").path(bookId).request().delete();
    assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatusInfo().getStatusCode());

    // GETs the Book and checks it has been deleted
    response = target(bookURI.toString()).request().get();
    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusInfo().getStatusCode());

  }

  @Test
  public void shouldNotCreateANullBook() throws JAXBException {
    // POSTs a Null Book
    Response response = target("/books").request().post(Entity.entity(null, MediaType.APPLICATION_XML));
    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatusInfo().getStatusCode());
  }

  @Test
  public void shouldNotFindTheBookID() throws JAXBException {
    // GETs a Book with an unknown ID
    Response response = target("/books").path("invalidID").request().get();
    assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatusInfo().getStatusCode());
  }
}
// end::adocSnippet[]
