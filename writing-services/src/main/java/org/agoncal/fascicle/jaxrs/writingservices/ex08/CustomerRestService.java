package org.agoncal.fascicle.jaxrs.writingservices.ex08;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;

import javax.ws.rs.*;
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
  public List<Customer> getCustomersByZipCodeCity(@QueryParam("zip") Long zip, @DefaultValue("Paris") @QueryParam("city") String city) {
    // ...
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
  public List<Customer> getCustomersByFirstnameName(@MatrixParam("firstname") String firstname, @DefaultValue("Smith") @MatrixParam("surname") String surname) {
    // ...
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
