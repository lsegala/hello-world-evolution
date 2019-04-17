package br.com.lsegala.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String sayHello(String name){
        return "Hello" + (name != null? ", " + name : "") + "!";
    }
}
