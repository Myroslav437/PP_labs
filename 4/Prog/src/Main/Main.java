package Main;
import UI.TUI;

public class Main {
    public static void main(String[] args) {
        TUI UserInterface = new TUI();
        try {
            UserInterface.execute();
        }
        catch (Exception exception) {
            // Log critical exception;
            return;
        }

        return;
    }
}
