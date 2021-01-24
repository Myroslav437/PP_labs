package UI;

import Common.Commands.ConsoleCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class HelpCommand extends ConsoleCommand{
    public HelpCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String res = "";
        if(arguments.isEmpty()) {
            res += "\n\t\t\tTour selector program\n" +
                   "To select the most suitable tour four you use the following commands:\n\n";
            for(var a : TUI.MainCommandsM) {
                ArrayList<String> arg = new ArrayList<String>();
                arg.add(a);
                res += a + ":\n" +  new InfoCommand(arg).Run() + "\n";
            }
            res = res.substring(0, res.length() - 1);
        }
        else {
            ArrayList<String> arg = new ArrayList<String>();
            arg.add(arguments.get(0));
            res += new InfoCommand(arg).Run();
        }
        return res;
    }

    @Override
    public String GetInfo() {
        return "Command signature: \"help [command_name]\" or \"help [void]\".\n" +
               "1) Returns information about a particular command\n" +
               "2) Returns general information about program all commands";
    }
}
