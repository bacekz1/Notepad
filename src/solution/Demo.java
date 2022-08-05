package solution;


public class Demo {
    public static void main(String[] args) {

        Page page = new Page("ala", "bala");
        System.out.println(page);
        SimpleNotepad test = new SimpleNotepad();
        for (int i = 0; i < 10; i++) {
            test.addText("test" + i, "ebasi qkoto");
        }
        test.printAll();
        System.out.println(test.addText(" wow2", 5));
        test.printAll();
        System.out.println(test.deleteText(9));
        test.printAll();
        System.out.println(test.searchWord("eba"));
        test.printAllPagesWithDigits();

        SecureNotepad test1 = new SecureNotepad("a");
        test1.addText("ala", "bala");
        ElectronicSecuredNotepad test2 = new ElectronicSecuredNotepad("a");
        System.out.println(test2.isStarted());
        test2.start();
        test2.addText("ala", "bala");
        System.out.println(test2);
        test2.printAll();

    }
}
