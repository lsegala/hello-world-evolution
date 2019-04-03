package br.com.lsegala.helloworld.bean;

public class HelloWorldService {
    private String name;

    public String sayHello(){
        return "Hello, "+name+"!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
