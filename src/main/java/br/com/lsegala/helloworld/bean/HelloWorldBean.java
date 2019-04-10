package br.com.lsegala.helloworld.bean;

import br.com.lsegala.helloworld.service.HelloWorldService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloWorldBean {
    @Inject
    private HelloWorldService helloWorldService;

    public String getMessage(){
        FacesContext fc = FacesContext.getCurrentInstance();
        String name = fc.getExternalContext().getRequestParameterMap().get("name");
        return helloWorldService.sayHello(name);
    }
}
