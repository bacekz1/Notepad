package solution;

public class SimpleNotepad implements INotepad {
    int pageNumber = 0;
    Page[] pages = new Page[8];

    @Override
    public boolean addText(String text, int pageNumber) {
        if (this.pageNumber > pageNumber) {
            pages[pageNumber].addText(text);
            if (pageNumber == pages.length) {
                reSizeArray();
            }
            return true;
        }
        return false;
    }

    @Override
    public void addText(String title, String text) {
        if (isArrayFilled()) {
            reSizeArray();
        }
        Page page = new Page(title, text);
        pages[this.pageNumber++] = page;
    }

    @Override
    public boolean rewriteText(String text, int pageNumber) {
        if (this.pageNumber > pageNumber) {
            pages[pageNumber].setText(text);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteText(int pageNumber) {
        if (this.pageNumber > pageNumber) {
            pages[pageNumber].deleteText();
            return true;
        }
        return false;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < pages.length; i++) {
            if (!isNull(pages[i])) {
                System.out.println(pages[i]);
            } else {
                break;
            }
        }
    }

    @Override
    public boolean searchWord(String word) {
        for (int i = 0; i < pages.length; i++) {
            if (!isNull(pages[i])) {
                if (pages[i].searchWord(word))
                    return true;
            } else {
                break;
            }
        }
        return false;
    }

    @Override
    public void printAllPagesWithDigits() {
        for (int i = 0; i < pages.length; i++) {
            if (!isNull(pages[i])) {
                if (pages[i].containsDigits())
                    System.out.println(pages[i].toString());
            } else {
                break;
            }
        }
    }

    private void reSizeArray() {
        Page[] pages1 = new Page[pages.length * 2];
        for (int i = 0; i < pages.length; i++) {
            pages1[i] = pages[i];
        }
        pages = pages1;
    }

    private boolean isArrayFilled() {
        return pages.length == pageNumber;
    }

    private boolean isNull(Page o) {
        return o == null;
    }
}
