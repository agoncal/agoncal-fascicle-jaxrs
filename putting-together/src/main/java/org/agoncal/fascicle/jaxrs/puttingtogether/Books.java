package org.agoncal.fascicle.jaxrs.puttingtogether;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@XmlRootElement
@XmlSeeAlso(Book.class)
public class Books extends ArrayList<Book> {

  public Books() {
    super();
  }

  public Books(Collection<? extends Book> c) {
    super(c);
  }

  @XmlElement(name = "book")
  public List<Book> getBooks() {
    return this;
  }

  public void setBooks(List<Book> books) {
    this.addAll(books);
  }
}
// end::adocsnippet[]
