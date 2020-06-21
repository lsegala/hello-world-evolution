package br.com.lsegala.helloworld.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements SayHello {
    public String sayHello(String name) {
        return "Hello world"+(name != null? ", "+name : "")+"!";
    }
}
