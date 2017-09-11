package org.agoncal.fascicle.jaxrs.writingservices.ex15;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Path("/customers")
public class CustomerRestService {

  @Path("{customerId}")
  public Customer getCustomer(@PathParam("customerId") Long customerId) {
    if (customerId < 1000)
      throw new IllegalArgumentException("Id must be greater than 1000!");

    Customer customer = customerService.find(customerId);
    if (customer == null)
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    return customer;
  }
  // tag::adocskip[]

  private CustomerService customerService = new CustomerService();

  private class CustomerService {
    public Customer find(Long customerId) {
      return null;
    }
  }
  // end::adocskip[]
}
// end::adocsnippet[]
