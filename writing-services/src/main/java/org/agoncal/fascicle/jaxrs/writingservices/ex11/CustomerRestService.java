package org.agoncal.fascicle.jaxrs.writingservices.ex11;

import org.agoncal.fascicle.jaxrs.writingservices.Customer;
import org.agoncal.fascicle.jaxrs.writingservices.Customers;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocsnippet[]
@Path("/customers")
public class CustomerRestService {

  @GET
  public Response getCustomers() {
    // tag::adocskip1[]
    System.out.println("getCustomers");
    Customers customers = new Customers();
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565"));
    customers.add(new Customer("John", "Smith", "jsmith@gmail.com", "1234565"));
    // end::adocskip1[]
    // ...
    return Response.ok(customers).build();
  }

  @GET
  @Path("{customerId}")
  public Response getCustomer(@PathParam("customerId") String customerId) {
    // tag::adocskip2[]
    System.out.println("getCustomer " + customerId);
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1334565");
    // end::adocskip2[]
    // ...
    return Response.ok(customer).build();
  }

  @POST
  public Response createCustomer(Customer customer) {
    // tag::adocskip3[]
    System.out.println("createCustomer " + customer);
    URI createdCustomerURI = UriBuilder.fromResource(CustomerRestService.class).path("1334").build();
    // end::adocskip3[]
    // ...
    return Response.created(createdCustomerURI).build();
  }

  @PUT
  public Response updateCustomer(Customer customer) {
    // tag::adocskip4[]
    System.out.println("updateCustomer " + customer);
    customer = new Customer("JohnUpdated", "Smith", "jsmith@gmail.com", "1334565");
    // end::adocskip4[]
    // ...
    return Response.ok(customer).build();
  }

  @DELETE
  @Path("{customerId}")
  public Response deleteCustomer(@PathParam("customerId") String customerId) {
    // tag::adocskip5[]
    System.out.println("getCustomer " + customerId);
    // end::adocskip5[]
    // ...
    return Response.noContent().build();
  }
}
// end::adocsnippet[]
