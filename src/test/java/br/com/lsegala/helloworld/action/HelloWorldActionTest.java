package br.com.lsegala.helloworld.action;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class HelloWorldActionTest {
    @ArquillianResource
    private URL base;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        return ShrinkWrap.create(WebArchive.class, "demo.war")
                .addPackages( true,
                        "br.com.lsegala.helloworld.action",
                        "br.com.lsegala.helloworld.form")
                .addAsLibraries(files)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/pages/template/default.jsp"), "pages/template/default.jsp")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/pages/helloWorld.jsp"), "pages/helloWorld.jsp")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/pages/helloWorldImpl.jsp"), "pages/helloWorldImpl.jsp")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/struts-config.xml"), "struts-config.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/tiles-def.xml"), "tiles-def.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"), "web.xml");
    }

    @Test
    @RunAsClient
    public void testWithNoArgs() throws IOException {
        assertTrue(sendRequestToServer(null).contains("Hello!"));
    }

    @Test
    @RunAsClient
    public void testWithArgs() throws IOException {
        assertTrue(sendRequestToServer("Sou%20Java").contains("Hello, Sou Java!"));
    }

    private String sendRequestToServer(String parameter) throws IOException {
        HttpURLConnection conn = null;
        String response = null;
        try {
            URL url = new URL(
                    this.base.toExternalForm() +
                    "helloWorld.do" +
                    (parameter != null? "?name="+parameter : ""));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            response = readOutput(new InputStreamReader(conn.getInputStream()));
        }finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }

    private String readOutput(InputStreamReader in) throws IOException {
        BufferedReader br = new BufferedReader(in);

        StringBuilder output = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            output.append(line);
        }
        return output.toString();
    }
}
