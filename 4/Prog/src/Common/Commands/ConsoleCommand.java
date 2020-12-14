package Common.Commands;
import java.util.ArrayList;

public abstract class ConsoleCommand implements AbstractCommand<String> {
    protected ArrayList<String> arguments;

    public ConsoleCommand(ArrayList<String> args) {
        arguments = new ArrayList<String>();
        if(args == null) {
            return;
        }
        else {
            arguments.addAll(args);
        }
        return;
    }

    public abstract  String GetInfo();
}