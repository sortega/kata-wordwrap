package info.nocive.wordwrap;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WordWrapTest {

    @Test
    public void emptyText() {
        assertEquals("\n", WordWrap.wrap("\n", 1));
        assertEquals("\n", WordWrap.wrap("", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void columnsMustBePositive() {
        WordWrap.wrap("Hello", 0);
    }

    @Test
    public void oneWordLine() {
        assertEquals("Hello\n", WordWrap.wrap("Hello\n", 10));
    }

    @Test
    public void wrapOneLine() {
        assertEquals("Hello\ncaracola\n", WordWrap.wrap("Hello caracola\n", 10));
    }

    @Test
    public void wrapLongWord() {
        assertEquals("Externocle\nomastoideo\n", WordWrap.wrap("Externocleomastoideo\n", 10));
    }

    @Test
    public void wrapVeryLongWord() {
        assertEquals("supercalif\nragilistic\noespialido\nso\n", WordWrap.wrap("supercalifragilisticoespialidoso\n", 10));
        assertEquals("and\nsupercalif\nragilistic\noespialido\nso yep\n", WordWrap.wrap("and supercalifragilisticoespialidoso yep\n", 10));
    }

    @Test
    public void wrapTwoLines() {
        String expected = "Hello world!\n" +
                "Today we are\n" +
                "going to learn\n" +
                "something.\n";
        String input = "Hello world! Today\n" +
                "we are going to\n" +
                "learn something.";
        assertEquals(expected, WordWrap.wrap(input, 15));
    }
}
