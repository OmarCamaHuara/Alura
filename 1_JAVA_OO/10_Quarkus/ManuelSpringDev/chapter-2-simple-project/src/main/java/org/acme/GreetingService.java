package org.acme;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {
    
    private final String greeting;

    public GreetingService(@ConfigProperty(name = "greeting.name") Optional<String> greeting){
        this.greeting = greeting.orElse("QUARKUS");
    }

    public String getGreeting(){
        return "Hello " + this.greeting;
    }
}
