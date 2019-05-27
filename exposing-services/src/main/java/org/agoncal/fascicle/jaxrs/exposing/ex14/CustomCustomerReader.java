package org.agoncal.fascicle.jaxrs.exposing.ex14;

import org.agoncal.fascicle.jaxrs.exposing.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.StringTokenizer;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Provider
@Consumes("custom/format")
public class CustomCustomerReader implements MessageBodyReader<Customer> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Customer.class.isAssignableFrom(type);
  }

  @Override
  public Customer readFrom(Class<Customer> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream inputStream) throws IOException, WebApplicationException {

    String str = convertStreamToString(inputStream);
    StringTokenizer s = new StringTokenizer(str, "/");

    Customer customer = new Customer();
    customer.setId(s.nextToken());
    customer.setFirstName(s.nextToken());
    customer.setLastName(s.nextToken());

    return customer;
  }
  // tag::adocSkip[]

  public String convertStreamToString(InputStream is)
    throws IOException {

    if (is != null) {
      Writer writer = new StringWriter();

      char[] buffer = new char[1024];
      try {
        Reader reader = new BufferedReader(
          new InputStreamReader(is, "UTF-8"));
        int n;
        while ((n = reader.read(buffer)) != -1) {
          writer.write(buffer, 0, n);
        }
      } finally {
        is.close();
      }
      return writer.toString();
    } else {
      return "";
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
