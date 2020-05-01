package br.com.lsegala.helloworld.action;

import org.apache.jasper.servlet.JspServlet;
import org.apache.struts.action.ActionServlet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;

import static org.junit.Assert.assertTrue;

public class HelloWorldActionTest {
    private ServletTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/demo");
        tester.addServlet(JspServlet.class, "*.jsp");
        ServletHolder actionServletHolder = tester.addServlet(ActionServlet.class, "*.do");
        actionServletHolder.setInitOrder(1);
        actionServletHolder.setInitParameter("config", "/WEB-INF/struts-config.xml");
        tester.setResourceBase("./src/main/webapp");
        tester.start();
    }

    @Test
    public void helloWorldHttpTestWithNoParams() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldActionTest.class.getName());
        request.setURI("/demo/helloWorld.do");
        response.parse(tester.getResponses(request.generate()));

        assertTrue(response.getContent().contains("Hello!"));
    }

    @Test
    public void helloWorldHttpTestWithParam() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldActionTest.class.getName());
        request.setURI("/demo/helloWorld.do?name=Sou%20Java");
        response.parse(tester.getResponses(request.generate()));

        assertTrue(response.getContent().contains("Hello, Sou Java!"));
    }

    @After
    public void tearDown() throws Exception {
        tester.stop();
    }
}
