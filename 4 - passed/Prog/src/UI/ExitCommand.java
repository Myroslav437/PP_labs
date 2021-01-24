package UI;
import Common.Commands.ConsoleCommand;
import java.util.ArrayList;

public class ExitCommand extends ConsoleCommand{
    public ExitCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() {
        System.exit(0);
        return null;
    }

    @Override
    public String GetInfo() {
        return "Command signature: \"exit [void]\".\n" +
               "This command terminates the program in a safe way";
    }
}
