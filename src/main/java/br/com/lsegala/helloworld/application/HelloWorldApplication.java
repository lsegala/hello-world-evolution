package br.com.lsegala.helloworld.application;

import br.com.lsegala.helloworld.page.HelloWorldPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {
    public Class<? extends Page> getHomePage() {
        return HelloWorldPage.class;
    }
}
