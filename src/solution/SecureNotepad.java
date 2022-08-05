package solution;

import java.util.Scanner;

public class SecureNotepad extends SimpleNotepad {

    public static final String ENTER_PASSWORD = "Enter password:";
    public static final String OPERATION_SUCCESSFUL = "Тhe operation was successfully completed";
    public static final String INVALID_PASSWORD = "Invalid password.";

    //should contain 1 lower char, 1 upper char and 1 digit. Minimum 5 characters
    private final String STRONG_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{5,}$";
    Scanner sc = new Scanner(System.in);
    private String password;

    //todo чакам отговор от Краси
    SecureNotepad(String password) {
        this.password = password;
    }

    @Override
    public boolean addText(String text, int pageNumber) {
        checkPassword();
        if (checkPassword()) {
            return super.addText(text, pageNumber);
        }
        return false;
    }

    @Override
    public void addText(String title, String text) {
        if (checkPassword()) {
            super.addText(title, text);
        }
    }

    @Override
    public boolean rewriteText(String text, int pageNumber) {
        if (checkPassword()) {
            return super.rewriteText(text, pageNumber);
        }
        return false;
    }

    @Override
    public boolean deleteText(int pageNumber) {
        if (checkPassword()) {
            return super.deleteText(pageNumber);
        }
        return false;
    }

    private boolean checkPassword() {
        System.out.println(ENTER_PASSWORD);
        String input = sc.nextLine();
        if (input.equals(password)) {
            System.out.println(OPERATION_SUCCESSFUL);
            return true;
        } else {
            System.out.println(INVALID_PASSWORD);
            return false;
        }
    }
}
