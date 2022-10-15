package org.swaggertest;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "Tutorial", description = "Study example"),
        @Tag(name = "Cake", description = "People who like cake")
    },
    info = @Info(
        title = "The fantastic cake factory",
        version = "1.0.0",
        contact = @Contact(
            name = "Talk to random",
            url = "https://github.com/OmarCamaHuara")),
    servers = {
        @Server(url = "http://localhost:9022")
    })

public class DescriptionSwagger extends Application {
    
}
