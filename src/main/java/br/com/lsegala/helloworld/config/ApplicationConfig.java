package br.com.lsegala.helloworld.config;

import br.com.lsegala.helloworld.api.HelloWorldREST;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Collections.singletonList(HelloWorldREST.class));
    }
}
