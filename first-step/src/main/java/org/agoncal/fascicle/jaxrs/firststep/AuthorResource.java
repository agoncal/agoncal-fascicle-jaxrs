package org.agoncal.fascicle.jaxrs.firststep;

// @formatter:off
// tag::adocSnippet[]
public class AuthorResource {

  private Long id;
  private String firstName;
  private String lastName;
  private String bio;
  private String email;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public AuthorResource firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public AuthorResource lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public AuthorResource surnbioame(String bio) {
    this.bio = bio;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AuthorResource email(String email) {
    this.email = email;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
