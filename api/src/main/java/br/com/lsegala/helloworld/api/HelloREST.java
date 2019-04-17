package br.com.lsegala.helloworld.api;

import br.com.lsegala.helloworld.HelloService;
import br.com.lsegala.helloworld.bean.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloREST {
    private final HelloService helloService;

    @Autowired
    public HelloREST(final HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public Content sayHello(){
        Content content = new Content();
        content.message = helloService.sayHello(null);
        return content;
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public Content sayHello(@PathVariable String name){
        Content content = new Content();
        content.message = helloService.sayHello(name);
        return content;
    }
}
