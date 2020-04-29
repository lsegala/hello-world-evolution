package br.com.lsegala.helloworld.api;

import javax.inject.Named;

@Named
public class GreetingService {

    public String greeting() {
        return greeting(null);
    }

    public String greeting(String name) {
        return "Hello" + (name != null? ", "+name : "") + "!";
    }

}
