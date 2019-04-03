package br.com.lsegala.helloworld.page;

import org.apache.wicket.protocol.http.WicketFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.jetty.servlet.FilterHolder;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;

import static org.junit.Assert.assertTrue;
import static org.mortbay.jetty.Handler.REQUEST;

public class HelloWorldActionTest {
    private ServletTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new ServletTester();
        tester.setContextPath("/demo");
        tester.addServlet("org.mortbay.jetty.servlet.DefaultServlet", "/");
        FilterHolder filter = tester.addFilter(WicketFilter.class, "/*", REQUEST);
        filter.setInitParameter("filterMappingUrlPattern", "/*");
        filter.setInitParameter("applicationClassName", "br.com.lsegala.helloworld.application.HelloWorldApplication");
        tester.start();
    }

    @Test
    public void helloWorldHttpTestWithNoParams() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldActionTest.class.getName());
        request.setURI("/demo/");
        response.parse(tester.getResponses(request.generate()));

        assertTrue(response.getContent().contains("Hello World!"));
    }

    @Test
    public void helloWorldHttpTestWithParam() throws Exception {
        HttpTester request = new HttpTester();
        HttpTester response = new HttpTester();

        request.setMethod("GET");
        request.setHeader("Host", HelloWorldActionTest.class.getName());
        String name = "Leonardo";
        request.setURI("/demo/?name="+name);
        response.parse(tester.getResponses(request.generate()));

        assertTrue(response.getContent().contains("Hello World, "+name+"!"));
    }

    @After
    public void tearDown() throws Exception {
        tester.stop();
    }
}
