package UI;

import java.util.ArrayList;

import Common.Utilities.CommandUtilities;
import Common.Commands.ConsoleCommand;

public class TUI {
    final public static String[] MainCommandsM = {
        "help",
        "info",
        "get",
        "discard",
        "exit",
    };

    enum arg {
        command,
        arg1,   arg2,   arg3,
        arg4,   arg5,   arg6,
        arg7,   arg8,   arg9
    }

    public void execute() throws Exception {
        System.out.println("\t\tTour selecting program.");
        System.out.println("Get stuck? Use \"help\" command.");

        // Main TUI cycle:
        while (true) {
            System.out.println("Waiting for your command: ");
            ArrayList<String> input =  CommandUtilities.GetTokCommand();
            String command = input.get(arg.command.ordinal());
            input.remove(arg.command.ordinal());

            // Run given command:
            String ClassName = "UI." + CommandUtilities.FormCommandClassName(command);
            try {
                // Create new command:
                ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, input);
                // Run command:
                String res = BrandNewCommand.Run();
                System.out.println(res);
            }
            catch (ClassNotFoundException exception) {
                System.out.println("Invalid command\n");
            }
            catch (IllegalArgumentException exception) {
                System.out.println("Invalid argument\n");
            }
            /*catch (Exception exception) {
                System.out.println("Error occurred");
                // Log everything;
            }*/
        }
    }
}
