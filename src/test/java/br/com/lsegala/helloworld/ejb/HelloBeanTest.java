package br.com.lsegala.helloworld.ejb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.naming.Context;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;

public class HelloBeanTest {
    private static final String JNDI = "java:global/demo/HelloBean";
    private EJBContainer ejbContainer;
    private Context context;

    @Before
    public void setUp(){
        ejbContainer = EJBContainer.createEJBContainer();
        context = ejbContainer.getContext();
    }

    @Test
    public void testHelloBlank() throws NamingException {
        SayHello helloBean = (SayHello) context.lookup(JNDI);
        assertEquals("Hello world!", helloBean.sayHello(null));
    }

    @Test
    public void testHelloWithName() throws NamingException {
        SayHello helloBean = (SayHello) context.lookup(JNDI);
        String name = "Sou Java";
        assertEquals("Hello world, "+name+"!", helloBean.sayHello(name));
    }

    @After
    public void tearDown(){
        ejbContainer.close();
    }
}
