package org.agoncal.fascicle.jaxrs.exposing.ex12;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/book")
public class BookResource {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Produces("text/plain")
    public String getBookTitle() {
        return "H2G2";
    }
}
