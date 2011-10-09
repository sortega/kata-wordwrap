package info.nocive.wordwrap;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTokenizer {
    private static final Pattern WORD_PATTERN = Pattern.compile("\\S+");
    private String text;

    public TextTokenizer(String text) {
        this.text = text;
    }

    public boolean hasNext() {
        return !text.trim().isEmpty();
    }

    public String next() {
        Matcher m = WORD_PATTERN.matcher(text);
        if (!m.find())
            throw new IllegalStateException();
        text = text.substring(m.end());
        return m.group();
    }
}
