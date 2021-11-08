package org.agoncal.fascicle.jaxrs.exposing.ex15;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Path("/customers")
public class CustomerResource {

  @Path("{customerId}")
  public Customer getCustomer(@PathParam("customerId") Long customerId) {
    if (customerId < 1000)
      throw new IllegalArgumentException("Id must be greater than 1000!");

    Customer customer = customerService.find(customerId);
    if (customer == null)
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    return customer;
  }
  // tag::adocSkip[]

  private CustomerService customerService = new CustomerService();

  private class CustomerService {
    public Customer find(Long customerId) {
      return null;
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
