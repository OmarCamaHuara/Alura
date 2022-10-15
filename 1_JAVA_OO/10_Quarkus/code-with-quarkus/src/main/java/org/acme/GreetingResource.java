package org.acme;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.acme.dto.Developer;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/hello")
public class GreetingResource {

    public static enum Order {
        desc, asc;
    }

    @GET
    @Operation(
        summary = "Return from examples HELLO",
        description = "Description the EndPoint"
    )
    @APIResponse(
        responseCode = "200",
        description = "Hello",
        content = @Content(
            mediaType = MediaType.TEXT_PLAIN,
            schema = @Schema(
                implementation = Developer.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo,
                        @QueryParam("order") String order,
                        @NotBlank @HeaderParam("auth") String auth) {
        return String.format("URI: %s - Order %s - Auth %s", uriInfo, order, auth);
    }


    @Operation(
        summary = "Return from examples HELLO",
        description = "Description the EndPoint"
    )
    @APIResponse(
        responseCode = "200",
        description = "Create",
        content = @Content(
            mediaType = MediaType.TEXT_PLAIN,
            schema = @Schema(
                implementation = Developer.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void create(String message){
        System.out.println(message + "Create");
    }

    @Operation(
        summary = "Return from examples HELLO",
        description = "Description the EndPoint"
    )
    @APIResponse(
        responseCode = "200",
        description = "Update",
        content = @Content(
            mediaType = MediaType.TEXT_PLAIN,
            schema = @Schema(
                implementation = Developer.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message){
        System.out.println(message + "Update");
        return message;
    }

    @Operation(
        summary = "Return from examples HELLO",
        description = "Description the EndPoint"
    )
    @APIResponse(
        responseCode = "200",
        description = "Delete",
        content = @Content(
            mediaType = MediaType.TEXT_PLAIN,
            schema = @Schema(
                implementation = Developer.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @DELETE
    public void delete(){
        System.out.println("Delete");
    }
}