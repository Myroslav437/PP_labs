package UI;
import Common.Commands.ConsoleCommand;
import DataBase.DataBase;

import java.io.IOException;
import java.util.ArrayList;

public class ReadCommand extends ConsoleCommand{
    public ReadCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() throws IOException{
        try {
            TUI.selector.connect(super.arguments.get(0));
            TUI.selector.read();
        }
        catch (IOException e) {
            throw e;
        }

        TUI.DBStatus = DataBase.Statuses.connected;
        return "Connected successfully\n";
    }

    @Override
    public String GetInfo() {
        return  "Command signature: \"read [path]\".\n" +
                "This command connects database to a particular file";
    }
}
