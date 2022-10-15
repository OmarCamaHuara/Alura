package org.acme.swagger;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "Quarkus tutoral", description = "Study example"),
        @Tag(name = "Developer", description = "CRUD")
    },
    info = @Info(
        title = "Register Developer factory",
        version = "1.0.0",
        contact = @Contact(
            name = "Talk to random",
            url = "https://github.com/OmarCamaHuara"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8072")
    }
)

public class SwaggerDescr extends Application{

}
