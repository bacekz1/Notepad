package solution;

public class ElectronicSecuredNotepad extends SecureNotepad implements ISecuredNotepad {
    private static final String DEVICE_OFF = "Please start device.";
    private boolean isStarted;

    public ElectronicSecuredNotepad(String password) {
        super(password);
    }

    @Override
    public boolean addText(String text, int pageNumber) {
        if (isStarted()) {
            return super.addText(text, pageNumber);
        } else {
            System.out.println(DEVICE_OFF);
            return false;
        }
    }

    @Override
    public void addText(String title, String text) {
        if (isStarted()) {
            super.addText(title, text);
        } else {
            System.out.println(DEVICE_OFF);
        }
    }

    @Override
    public boolean rewriteText(String text, int pageNumber) {
        if (isStarted()) {
            return super.rewriteText(text, pageNumber);
        } else {
            System.out.println(DEVICE_OFF);
            return false;
        }
    }

    @Override
    public boolean deleteText(int pageNumber) {
        if (isStarted()) {
            return super.deleteText(pageNumber);
        } else {
            System.out.println(DEVICE_OFF);
            return false;
        }
    }

    @Override
    public void start() {
        this.isStarted = true;
    }

    @Override
    public void strop() {
        this.isStarted = false;
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }
}
