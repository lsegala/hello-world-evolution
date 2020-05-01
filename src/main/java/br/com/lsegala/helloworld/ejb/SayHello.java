package br.com.lsegala.helloworld.ejb;

import javax.ejb.Stateless;

@Stateless
public interface SayHello {
    public String sayHello(String name);
}
