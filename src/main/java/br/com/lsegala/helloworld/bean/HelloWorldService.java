package br.com.lsegala.helloworld.bean;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloWorldService {
    private String name;

    public String sayHello() throws InterruptedException {
        TimeUnit.SECONDS.sleep(
                new Random().ints(1, 10)
                    .findFirst().orElse(0));
        return "Hello, "+name+"!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
