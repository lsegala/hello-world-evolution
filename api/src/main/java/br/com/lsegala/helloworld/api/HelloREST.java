package br.com.lsegala.helloworld.api;

import br.com.lsegala.helloworld.HelloService;
import br.com.lsegala.helloworld.bean.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloREST {
    private final HelloService helloService;

    @Autowired
    public HelloREST(final HelloService helloService) {
        this.helloService = helloService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public Content sayHello(){
        Content content = new Content();
        content.message = helloService.sayHello(null);
        return content;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public Content sayHello(@PathVariable String name){
        Content content = new Content();
        content.message = helloService.sayHello(name);
        return content;
    }
}
