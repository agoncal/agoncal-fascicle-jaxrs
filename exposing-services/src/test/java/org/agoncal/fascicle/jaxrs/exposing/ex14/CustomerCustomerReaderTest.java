package org.agoncal.fascicle.jaxrs.exposing.ex14;

import org.agoncal.fascicle.jaxrs.exposing.Customer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerCustomerReaderTest {

  public static final String CUSTOM = "1234/John/Smith";


  @Test
  public void shouldReadFrom() throws Exception {

    CustomCustomerReader reader = new CustomCustomerReader();
    Customer customer = reader.readFrom(Customer.class, null, null, null, null, toInputStream(CUSTOM));

    assertEquals("1234", customer.getId());
    assertEquals("John", customer.getFirstName());
    assertEquals("Smith", customer.getLastName());
  }

  private InputStream toInputStream(String str) throws IOException {

    // convert String into InputStream
    InputStream is = new ByteArrayInputStream(str.getBytes());

    return is;
  }
}
