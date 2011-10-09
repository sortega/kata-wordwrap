package info.nocive.wordwrap;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextTokenizerTest {

    @Test
    public void emptyText() {
        TextTokenizer instance = new TextTokenizer("");
        assertFalse(instance.hasNext());

        TextTokenizer instance2 = new TextTokenizer("\n");
        assertFalse(instance2.hasNext());
    }

    @Test
    public void someWords() {
        TextTokenizer instance = new TextTokenizer("Hello world!\n");
        assertTrue(instance.hasNext());
        assertEquals("Hello", instance.next());
        assertTrue(instance.hasNext());
        assertEquals("world!", instance.next());
        assertFalse(instance.hasNext());
    }
}
