import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testOutputHelloWorld(){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            String[] args = new String[1];
            App.main(args);
        }finally {
            System.setOut(console);
        }
        assertEquals("Hello world!\n", bytes.toString());
    }
}
