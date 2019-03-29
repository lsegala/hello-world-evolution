import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private static final String EOL = System.getProperty("line.separator");
    private PrintStream console;
    private ByteArrayOutputStream bytes;

    @Before
    public void setUp(){
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void testOutputHelloWorldWithNull(){
        App.main(new String[]{});
        assertEquals("Hello world!"+EOL, bytes.toString());
    }

    @Test
    public void testOutputHelloWorld(){
        App.main(new String[]{"Leonardo"});
        assertEquals("Hello world, Leonardo!"+EOL, bytes.toString());
    }

    @After
    public void tearDown(){
        System.setOut(console);
    }
}
