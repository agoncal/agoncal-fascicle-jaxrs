package org.agoncal.fascicle.jaxrs.puttingtogether;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class URISplitTest {

  @Test
  public void shouldGetTheLastPath() {

    String id = "http://localhost:8080/chapter15-service-1.0/rs/book/33".split("/")[6];
    assertEquals("33", id);
  }
}
