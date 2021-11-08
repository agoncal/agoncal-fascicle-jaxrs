package org.agoncal.fascicle.jaxrs.invoking.ex02;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.agoncal.fascicle.jaxrs.invoking.Book;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Path("/books")
public class BookResource {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getBookTitle() {
    return "H2G2";
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Book getBook() {
    return new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
  }
}
