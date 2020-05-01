package br.com.lsegala.helloworld.action;

import br.com.lsegala.helloworld.bean.HelloWorldService;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class HelloWorldServiceTest extends AbstractDependencyInjectionSpringContextTests {
    protected HelloWorldService helloWorldService;

    public HelloWorldServiceTest() {
        setPopulateProtectedVariables(true);
    }

    public void testVariableInjected(){
        assertNotNull(helloWorldService);
    }

    public void testDefaultValue() throws InterruptedException {
        assertEquals("Hello, Spring!", helloWorldService.sayHello());
    }

    public void testCustomValue() throws InterruptedException {
        helloWorldService.setName("Sou Java");
        assertEquals("Hello, Sou Java!", helloWorldService.sayHello());
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:application-context.xml"};
    }
}
