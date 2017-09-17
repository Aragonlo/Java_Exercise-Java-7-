package com.example.helloworld.resources;

import com.example.helloworld.api.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

//Tells Jersey that this resource is accessible at the URI
@Path("/hello-world")
//Lets Jersey’s content negotiation code know that this resource produces 
// representations which are application/json
@Produces(MediaType.APPLICATION_JSON)


public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    // An AtomicLong provides us with a cheap, 
    //thread-safe way of generating unique(ish) IDs.
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed  // Dropwizard automatically records the duration and rate of its 
            //invocations as a Metrics Timer.
    //The @QueryParam("name") annotation tells Jersey to map the name parameter 
    // from the query string to the name parameter in the method
    // Optional -> optional parameter
    // You can swap Optional<String> parameter with NonEmptyStringParam if you want /hello-world?name= 
    // to return “Hello, Stranger!” 
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}