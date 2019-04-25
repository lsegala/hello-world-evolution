package br.com.lsegala.helloworld.api;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public CompletionStage<String> greeting(@PathParam("name") String name) {
        return this.sayHello(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> hello() {
        return this.sayHello(null);
    }

    private CompletionStage<String> sayHello(String name){
        return service.greeting(name);
    }
}