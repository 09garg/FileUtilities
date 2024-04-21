import Exceptions.ReadFileException;
import Exceptions.WriteFileException;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReverseStringTest {

    @Test
    public void testReadFile() {
        try {
            StringBuilder input = ReverseString.readFile();
            assertNotNull(input);
            assertFalse(input.toString().isEmpty());
        } catch (ReadFileException ex) {
            fail("Exception occurred while reading file: " + ex.getMessage());
        }
    }

    @Test
    public void testReverseString() {
        StringBuilder input = new StringBuilder("Hello, world!");
        StringBuilder reversed = ReverseString.reverseString(input);
        assertEquals("!dlrow ,olleH", reversed.toString());
    }

    @Test
    public void testWriteFile() {
        StringBuilder input = new StringBuilder("Test string");
        try {
            ReverseString.writeFile(input.toString());
            // Add assertions to check if the file has been written properly, if needed
        } catch (WriteFileException ex) {
            fail("Exception occurred while writing to file: " + ex.getMessage());
        }
    }
}