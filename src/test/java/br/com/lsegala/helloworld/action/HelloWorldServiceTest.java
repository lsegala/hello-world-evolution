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

    public void testDefaultValue(){
        assertEquals("Hello, Spring!", helloWorldService.sayHello());
    }

    public void testCustomValue(){
        helloWorldService.setName("Leonardo");
        assertEquals("Hello, Leonardo!", helloWorldService.sayHello());
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:application-context.xml"};
    }
}
