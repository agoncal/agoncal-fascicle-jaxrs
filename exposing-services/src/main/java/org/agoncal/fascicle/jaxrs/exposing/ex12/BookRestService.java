package org.agoncal.fascicle.jaxrs.exposing.ex12;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/book")
public class BookRestService {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Produces("text/plain")
    public String getBookTitle() {
        return "H2G2";
    }
}
