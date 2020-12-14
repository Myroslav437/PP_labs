package UI;
import Common.Commands.*;
import Common.Utilities.CommandUtilities;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class InfoCommand extends ConsoleCommand {
    public InfoCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException {
        String  command = "UI." + CommandUtilities.FormCommandClassName(super.arguments.get(0));
        try {
            ConsoleCommand tmp = UICommandFactory.createConsoleCommand(command, null);
            return tmp.GetInfo() + "\n";
        }
        catch (ClassNotFoundException exception) {
            throw new IllegalArgumentException("Command class "+ command + " not found");
        }

    }

    @Override
    public String GetInfo() {
        return  "Command signature \"info [command_name]\". \n" +
                "Returns the information about a particular class\n" +
                "Helper command for the \"help\" command";
    }
}
