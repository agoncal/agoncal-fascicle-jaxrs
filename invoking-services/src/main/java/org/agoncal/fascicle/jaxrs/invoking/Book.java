package org.agoncal.fascicle.jaxrs.invoking;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@XmlRootElement
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Long id;
  private String title;
  private Float price;
  private String description;
  private String isbn;
  private Integer nbOfPage;
  private Boolean illustrations;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
    this.illustrations = illustrations;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", price=" + price +
      ", description='" + description + '\'' +
      ", isbn='" + isbn + '\'' +
      ", nbOfPage=" + nbOfPage +
      ", illustrations=" + illustrations +
      '}';
  }
}
