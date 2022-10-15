package org.swaggertest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;


@Path("/cake")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CakeResource {

    private Set<Cake> cakes;

    public CakeResource(){
        cakes = new HashSet<>();
        cakes.add(new Cake("Chocolate","The best cake in the world"));
        cakes.add(new Cake("Sensation","Chocolate with strawberry"));
    }

    @GET
    @Operation(
        summary = "Return all register cakes",
        description = "Description the endPoint"
    )
    @APIResponse(
        responseCode = "200",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                implementation = Cake.class,
                type = SchemaType.ARRAY
            )
        )
    )
    public Set<Cake> list() {
        return cakes;
    }

    @Operation(
        summary = "Cake Update",
        description = "Description for update"
    )
    @APIResponse(
        responseCode = "200",
        description = "Add cakes",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                implementation = Cake.class,
                type = SchemaType.ARRAY
            )
        ) 
    )
    @POST
    public Set<Cake> add(Cake cake){
        cakes.add(cake);
        return cakes;
    }

    @Operation( summary = "Delete cake for name")        
    @APIResponse(
        responseCode = "200",
        description = "All registered cakes except the one withdrawn ",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                implementation = Cake.class,
                type = SchemaType.ARRAY
            )
        )
    )
    @DELETE
    @Path("/{name}")
    public Set<Cake> delete(@Parameter(description = "Name of the cakes to be removed", required = true)
                            @QueryParam("name") String name){
        cakes.removeIf(existingCake -> existingCake.name.equals(name));
        return cakes;
    }
}