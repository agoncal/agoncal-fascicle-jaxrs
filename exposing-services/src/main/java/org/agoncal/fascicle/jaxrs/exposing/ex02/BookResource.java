package org.agoncal.fascicle.jaxrs.exposing.ex02;

import org.agoncal.fascicle.jaxrs.exposing.Book;
import org.agoncal.fascicle.jaxrs.exposing.Books;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
// tag::adocSnippet[]
@Path("/books")
@Transactional
public class BookResource {

  @Context
  private UriInfo uriInfo;

  @PersistenceContext(unitName = "jaxrsPU")
  private EntityManager em;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Books getAllBooks() {
    TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
    Books books = new Books(query.getResultList());
    return books;
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Book getBook(@PathParam("id") Long bookId) {
    return em.find(Book.class, bookId);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createBook(Book book) {
    em.persist(book);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  public Response createBookWithTitle(String title) {
    Book book = new Book();
    book.setTitle(title);
    em.persist(book);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteBook(@PathParam("id") Long bookId) {
    em.remove(em.find(Book.class, bookId));
    return Response.noContent().build();
  }
}
// end::adocSnippet[]
