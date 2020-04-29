package br.com.lsegala.helloworld.api;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@DefaultDeployment(type = DefaultDeployment.Type.WAR)
public class GreetingResourceTest {
    @Inject
    private GreetingResource greetingResource;

    @Deployment
    public static WebArchive demoDeployment(){
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(
                        true, Filters.exclude("*Test*"),
                        GreetingResource.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testWithNoArg(){
        final Response response = greetingResource.hello();
        assertEquals("Hello!", response.getEntity()+"");
    }

    @Test
    public void testWithArg(){
        final Response response = greetingResource.greeting("SouJava");
        assertEquals("Hello, SouJava!", response.getEntity()+"");
    }
}
