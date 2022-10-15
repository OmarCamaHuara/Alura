package org.acme;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.acme.dto.Developer;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/developer")
public class DeveloperResource {
    

    @Operation(
        summary = "Return from examples",
        description = "Description the EndPoint"
    )
    @APIResponse(
        responseCode = "200",
        description = "Create Developer",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                implementation = Developer.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer){
        developer.persist();
        return Response.created(
            UriBuilder
            .fromResource(DeveloperResource.class)
            .path(Long.toString(developer.getId()))
            .build()
        ).entity(developer)
        .build();
    }
}
