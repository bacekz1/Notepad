package solution;

public class Page {
    private static final String empty = "";
    private final String title;
    private String text;

    public Page(String title, String text) {
        this.title = title;
        this.text = text;
    }

    void addText(String text) {
        this.text = this.text.concat(text);
    }

    void deleteText() {
        this.text = empty;
    }

    void setText(String text) {
        this.text = text;
    }

    boolean searchWord(String word) {
        return (this.text.toLowerCase().contains(word.toLowerCase()));
    }

    boolean containsDigits() {
        for (int i = 0; i < text.length(); i++) {
            if ((Character.isDigit(text.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("title:%s\ntext:%s", this.title, this.text);
    }
}
