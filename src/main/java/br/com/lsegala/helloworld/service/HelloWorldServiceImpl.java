package br.com.lsegala.helloworld.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldServiceImpl implements HelloWorldService {
    public String sayHello(String name){
        return "Hello"+(name != null? ", "+name : "")+"!";
    }
}
