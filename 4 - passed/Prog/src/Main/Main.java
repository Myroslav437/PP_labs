package Main;
import Logger.Logger;
import UI.TUI;

public class Main {
    public static Logger logger;

    public static void main(String[] args) {
        logger = new Logger();
        TUI UserInterface = new TUI();

        try {
            UserInterface.execute();
        }
        catch (Exception exception) {
            logger.sendMessage(exception.getMessage());
            return;
        }

        return;
    }
}
