package UI;
import Common.Commands.ConsoleCommand;
import java.util.ArrayList;

public class GetCommand extends ConsoleCommand{
    final private static String[] TourParams = new String[] {
            "price",
            "transport",
            "eatings",
            "days",
    };

    final private static String[] getCommandArgsMod = new String[] {
            "below",
            "over",
            "editable",
            "not-editable",
    };

    public GetCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() {
        return null;
    }

    @Override
    public String GetInfo() {
        return "Command signature: \"get [parameter, specifier, value]\" or \"get [void]\".\n" +
               "1) This command applies given filter to the tours.\n" +
               "   Reusing the command imposes the new filter on the previously shown sample\n" +
               "2) \"get\" command with no parameters shows tours with current filter\n" +
               "To cancel applied filters use \"discard\" command";
    }
}
