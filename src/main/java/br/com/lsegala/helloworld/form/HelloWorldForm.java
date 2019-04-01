package br.com.lsegala.helloworld.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
