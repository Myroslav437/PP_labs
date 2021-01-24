package UI;
import Common.Commands.ConsoleCommand;

import java.io.IOException;
import java.util.ArrayList;

public class DiscardCommand extends ConsoleCommand{
    public DiscardCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() throws IOException  {
        TUI.selector.clearFilter();
        return "";
    }

    @Override
    public String GetInfo() {
        return  "Command signature: \"discard [void]\".\n" +
                "This command discards all filters which were applied using \"get\" command";
    }
}
