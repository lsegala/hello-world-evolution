package br.com.lsegala.helloworld.api;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Response greeting(@PathParam("name") String name) {
        return Response.ok(service.greeting(name)).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public Response hello() {
        return Response.ok(service.greeting()).build();
    }
}