package org.agoncal.fascicle.jaxrs.understanding;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/authors")
@Produces(MediaType.TEXT_PLAIN)
@OpenAPIDefinition(
  info = @Info(
    title = "Authors",
    version = "1.0",
    description = "Operations on authors"
  ),
  tags = {
    @Tag(name = "author"),
    @Tag(name = "book")
  }
)
public class AuthorResource {

  String[] scifiAuthors = {"Isaac Asimov", "Ray Bradbury", "Douglas Adams"};

  @GET
  @Operation(summary = "Gets all the sci-fi authors", tags = {"scifi"},
    responses = {
      @ApiResponse(responseCode = "200", description = "Comma-separated list of sci-fi authors")
    })
  public String getAllScifiAuthors() {
    return String.join(", ", scifiAuthors);
  }

  @GET
  @Path("/{index}")
  @Operation(summary = "Gets a sci-fi author by index",
    tags = {"scifi"},
    responses = {
      @ApiResponse(responseCode = "200", description = "A sci-fi author"),
      @ApiResponse(responseCode = "400", description = "Invalid index supplied"),
      @ApiResponse(responseCode = "404", description = "Author not found")}
  )
  public String getScifiAuthor(@Parameter(description = "Author index", required = true) @PathParam("index") int index) {
    return scifiAuthors[index];
  }
}
