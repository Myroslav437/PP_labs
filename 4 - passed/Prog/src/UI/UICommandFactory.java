package UI;
import Common.Commands.ConsoleCommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class UICommandFactory {
    public static ConsoleCommand createConsoleCommand(String command, ArrayList<String> args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Create command class:
        Class<?> NewCommandC = Class.forName(command);
        Constructor<?> NewCommandCtor = NewCommandC.getConstructor(ArrayList.class);
        return  ((ConsoleCommand) NewCommandCtor.newInstance(new Object[]{args}));
    }
}
