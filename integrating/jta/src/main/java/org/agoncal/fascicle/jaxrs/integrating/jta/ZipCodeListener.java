package org.agoncal.fascicle.jaxrs.integrating.jta;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@ApplicationScoped
public class ZipCodeListener {

  @Inject
  private ZipCodeChecker checker;

  @PrePersist
  @PreUpdate
  private void checkZipCode(Address address) {
    if (!checker.isValid(address.getZipcode()))
      throw new IllegalArgumentException("Invalid zipcode");
  }

}
// end::adocSnippet[]
