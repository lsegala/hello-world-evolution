package br.com.lsegala.helloworld.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HelloWorldPage extends WebPage {
    public HelloWorldPage() {
        add(new Label("message", "Hello World!"));
    }

    public HelloWorldPage(PageParameters parameters) {
        String compl = parameters.get("name") != null? ", "+parameters.get("name") : "";
        add(new Label("message", "Hello World"+compl+"!"));
    }
}
