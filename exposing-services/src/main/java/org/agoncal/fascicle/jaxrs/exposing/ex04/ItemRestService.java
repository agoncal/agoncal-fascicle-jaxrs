package org.agoncal.fascicle.jaxrs.exposing.ex04;

import org.agoncal.fascicle.jaxrs.exposing.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Path("/items")
public class ItemRestService {

  @GET
  public Items getItems() {
    // URI : /items
    // tag::adocskip1[]
    Items items = new Items();
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
    // end::adocskip1[]
  }

  @GET
  @Path("/cds")
  public CDs getCDs() {
    // URI : /items/cds
    // tag::adocskip2[]
    CDs cds = new CDs();
    cds.add(new CD("Help", 12.5F, "Best Beatles album", "EMI", 1, 45.6F, "Pop"));
    return cds;
    // end::adocskip2[]
  }

  @GET
  @Path("/books")
  public Books getBooks() {
    // URI : /items/books
    // tag::adocskip3[]
    Books books = new Books();
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return books;
    // end::adocskip3[]
  }

  @POST
  @Path("/books")
  public Response createBook(Book book) {
    // URI : /items/book
    // tag::adocskip4[]
    return Response.created(null).build();
    // end::adocskip4[]
  }
}
// end::adocsnippet[]
