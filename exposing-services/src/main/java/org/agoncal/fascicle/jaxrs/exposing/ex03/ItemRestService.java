package org.agoncal.fascicle.jaxrs.exposing.ex03;

import org.agoncal.fascicle.jaxrs.exposing.Book;
import org.agoncal.fascicle.jaxrs.exposing.Items;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/items")
public class ItemRestService {

  @GET
  public Items getItems() {
    // ...
    // tag::adocsskip[]
    Items items = new Items();
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    items.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
    // end::adocsskip[]
  }
}
// end::adocSnippet[]
