package br.com.lsegala.helloworld.servlet;

import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.testing.HttpTester;
import org.eclipse.jetty.testing.ServletTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldServletTest {
    private ServletTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/demo");
        tester.addServlet(HelloWorldServlet.class, "/hello/*");
        tester.addServlet(DefaultServlet.class, "/");
        tester.start();
    }

    @Test
    public void helloWorldHttpTestWithNoParams() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldServletTest.class.getName());
        request.setURI("/demo/hello");
        response.parse(tester.getResponses(request.generate()));

        assertEquals("<html><body><h1>Hello World!</h1></body></html>", response.getContent());
    }

    @Test
    public void helloWorldHttpTestWithParam() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldServletTest.class.getName());
        request.setURI("/demo/hello?name=Sou Java");
        response.parse(tester.getResponses(request.generate()));

        assertEquals("<html><body><h1>Hello World, Leonardo!</h1></body></html>", response.getContent());
    }

    @After
    public void tearDown() throws Exception {
        tester.stop();
    }
}
