package org.agoncal.fascicle.jaxrs.exposing.ex15;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
// tag::adocSnippet[]
@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {

  public Response toResponse(jakarta.persistence.EntityNotFoundException ex) {
    return Response.status(404).entity(ex.getMessage()).type(MediaType.TEXT_PLAIN).build();
  }
}
// end::adocSnippet[]
