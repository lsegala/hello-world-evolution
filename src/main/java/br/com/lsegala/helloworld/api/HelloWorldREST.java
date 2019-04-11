package br.com.lsegala.helloworld.api;

import br.com.lsegala.helloworld.bean.Info;
import br.com.lsegala.helloworld.service.HelloWorldService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("hello")
@Produces(APPLICATION_JSON)
public class HelloWorldREST {
    @Inject
    private HelloWorldService helloWorldService;

    @GET
    @Path("")
    public Info sayHello(){
        Info info = new Info();
        info.message = helloWorldService.sayHello(null);
        return info;
    }

    @GET
    @Path("{name}")
    public Info sayHello(@PathParam("name") final String name){
        Info info = new Info();
        info.message = helloWorldService.sayHello(name);
        return info;
    }
}
