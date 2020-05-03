package br.com.lsegala.helloworld.action;

import br.com.lsegala.helloworld.bean.Info;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class HelloWorldRESTTest {
    @ArquillianResource
    private URL base;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        return ShrinkWrap.create(WebArchive.class, "demo.war")
                .addPackages( true, "br.com.lsegala.helloworld")
                .addAsLibraries(files)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"), "web.xml");
    }

    @Test
    @RunAsClient
    public void testWithNoArgs() throws IOException {
        Client client = ClientBuilder.newClient();
        Response response = client.target(this.base.toExternalForm() + "rest/hello").request("application/json").get();
        Info info = objectMapper.readValue(response.readEntity(String.class), Info.class);
        assertEquals("Hello!", info.message);
    }

    @Test
    @RunAsClient
    public void testWithArgs() throws IOException {
        Client client = ClientBuilder.newClient();
        Response response = client.target(this.base.toExternalForm() + "rest/hello/Sou Java").request("application/json").get();
        Info info = objectMapper.readValue(response.readEntity(String.class), Info.class);
        assertEquals("Hello, Sou Java!", info.message);
    }
}
