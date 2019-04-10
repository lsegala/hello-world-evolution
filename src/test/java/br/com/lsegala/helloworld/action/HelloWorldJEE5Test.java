package br.com.lsegala.helloworld.action;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class HelloWorldJEE5Test {
    @ArquillianResource
    private URL base;

    @Drone
    private WebDriver webDriver;

    @FindBy(id="helloMessage")
    private WebElement message;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        File[] files = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeDependencies()
                .resolve()
                .withTransitivity()
                .asFile();

        return ShrinkWrap.create(WebArchive.class, "demo.war")
                .addPackages( true, "br.com.lsegala.helloworld.bean", "br.com.lsegala.helloworld.service")
                .addAsLibraries(files)
                .addAsWebResource(new File("src/main/webapp/helloWorld.xhtml"))
                .addAsWebResource(new File("src/main/webapp/templates/default.xhtml"), "templates/default.xhtml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/faces-config.xml"), "faces-config.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/web.xml"), "web.xml");
    }

    @Test
    @RunAsClient
    public void testWithNoArgs() {
        webDriver.get(this.base.toExternalForm() + "helloWorld.jsf");
        assertEquals("Hello!", message.getText());
    }

    @Test
    @RunAsClient
    public void testWithArgs() {
        webDriver.get(this.base.toExternalForm() + "helloWorld.jsf?name=Leonardo");
        assertEquals("Hello, Leonardo!", message.getText());
    }
}
