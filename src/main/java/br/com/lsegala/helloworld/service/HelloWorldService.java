package br.com.lsegala.helloworld.service;

import javax.ejb.Local;

@Local
public interface HelloWorldService {
    String sayHello(String name);
}
