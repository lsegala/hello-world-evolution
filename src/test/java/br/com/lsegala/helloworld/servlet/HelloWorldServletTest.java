package br.com.lsegala.helloworld.servlet;

import org.apache.jasper.servlet.JspServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.jetty.servlet.DefaultServlet;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloWorldServletTest {
    private static final String EOL = System.getProperty("line.separator");
    private ServletTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/demo");
        tester.addServlet(HelloWorldServlet.class, "/hello/*");
        tester.addServlet(JspServlet.class, "*.jsp");
        tester.addServlet(DefaultServlet.class, "/");
        tester.setResourceBase("./src/main/webapp");
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

        assertTrue(response.getContent().contains("Hello!"));
    }

    @Test
    public void helloWorldHttpTestWithParam() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldServletTest.class.getName());
        request.setURI("/demo/hello?name=Sou%20Java");
        response.parse(tester.getResponses(request.generate()));

        assertTrue(response.getContent().contains("Hello, Sou Java!"));
    }

    @After
    public void tearDown() throws Exception {
        tester.stop();
    }
}
