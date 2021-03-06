package org.agoncal.fascicle.jaxrs.exposing.ex05;

import org.agoncal.fascicle.jaxrs.exposing.Customer;
import org.agoncal.fascicle.jaxrs.exposing.Customers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Path("/customers")
public class CustomerRestService {

  @GET
  @Path("search/{text}")
  public List<Customer> searchCustomers(@PathParam("text") String textToSearch) {
    // URI : /customers/search/smith
    // tag::adocskip1[]
    System.out.println("searchCustomer : " + textToSearch);
    Customers customers = new Customers();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
    // end::adocskip1[]
  }

  @GET
  @Path("{login: [a-zA-Z]*}")
  public Customer getCustomerByLogin(@PathParam("login") String login) {
    // URI : /customers/foobarsmith
    // tag::adocskip2[]
    System.out.println("getCustomerByLogin : " + login);
    return new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    // end::adocskip2[]
  }

  @GET
  @Path("{customerId : \\d+}")
  public Customer getCustomerById(@PathParam("customerId") Long id) {
    // URI : /customers/12345
    // tag::adocskip3[]
    System.out.println("getCustomerById : " + id);
    return new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    // end::adocskip3[]
  }
}
// end::adocsnippet[]
