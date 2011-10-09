package info.nocive.wordwrap;

public class WordWrap {

    private final int columns;
    private int lineLength;
    private String out;

    public static String wrap(String text, int columns) {
        return new WordWrap(columns).wrap(new TextTokenizer(text));
    }

    private WordWrap(int columns) {
        if (columns <= 0)
            throw new IllegalArgumentException("Columns must be bigger than 0");
        this.columns = columns;
        this.lineLength = 0;
        this.out = "";
    }

    private String wrap(TextTokenizer text) {
        while(text.hasNext())
            addWord(text.next());
        endLastLine();
        return out;
    }

    private void endLastLine() {
        out += "\n";
    }

    private void addWord(String word) {
        appendSeparatorFor(word);
        if (hasRoomFor(word.length()))
            append(word);
        else
            splitWord(word);
    }

    private void appendSeparatorFor(String word) {
        if (isLineStart())
            return;
        if (hasRoomFor(word.length() + 1))
            append(" ");
        else
            newLine();
    }

    private void splitWord(String word) {
        String wordBegin = word.substring(0, columns - lineLength);
        String wordEnd   = word.substring(columns - lineLength);
        append(wordBegin);
        addWord(wordEnd);
    }

    private boolean isLineStart() {
        return lineLength == 0;
    }

    private boolean hasRoomFor(int characters) {
        return lineLength + characters <= columns;
    }

    private void newLine() {
        out += "\n";
        lineLength = 0;
    }

    private void append(String text) {
        out += text;
        lineLength += text.length();
    }

}
