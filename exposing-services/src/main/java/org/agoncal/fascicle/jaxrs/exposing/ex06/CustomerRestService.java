package org.agoncal.fascicle.jaxrs.exposing.ex06;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
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
  public List<Customer> getCustomersByZipCodeCity(@QueryParam("zip") Long zip, @QueryParam("city") String city) {
    // URI : /customer?zip=75012&city=Paris
    // tag::adocskip1[]
    System.out.println("getCustomerByZipCodeCity : " + zip + " - " + city);
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
    // end::adocskip1[]
  }

  @GET
  @Path("search")
  public List<Customer> getCustomersByFirstnameName(@MatrixParam("firstname") String firstname, @MatrixParam("surname") String surname) {
    // URI : /customer/search;firstname=Antonio;surname=Goncalves
    // tag::adocskip2[]
    System.out.println("getCustomerByFirstnameName : " + firstname + " - " + surname);
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
    // end::adocskip2[]
  }
}
// end::adocsnippet[]
