package org.agoncal.fascicle.jaxrs.exposing.ex03;

import org.agoncal.fascicle.jaxrs.exposing.Book;
import org.agoncal.fascicle.jaxrs.exposing.Items;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/items")
public class ItemResource {

  @GET
  public Items getItems() {
    // ...
    // tag::adocSkip[]
    Items items = new Items();
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
    // end::adocSkip[]
  }
}
// end::adocSnippet[]
