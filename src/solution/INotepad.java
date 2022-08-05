package solution;

public interface INotepad {
    boolean addText(String text, int pageNumber);

    void addText(String title,String text);

    boolean rewriteText(String text, int pageNumber);

    boolean deleteText(int pageNumber);

    void printAll();

    boolean searchWord(String word);

    void printAllPagesWithDigits();
}
