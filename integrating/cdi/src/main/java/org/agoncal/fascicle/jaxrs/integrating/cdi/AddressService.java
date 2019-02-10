package org.agoncal.fascicle.jaxrs.integrating.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

// tag::adocSnippet[]
@ApplicationScoped
public class AddressService {

  @Inject
  private EntityManager em;

  public Address save(Address address) {
    em.getTransaction().begin();
    em.persist(address);
    em.getTransaction().commit();
    return address;
  }
}
// end::adocSnippet[]
