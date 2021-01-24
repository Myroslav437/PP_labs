package UI;

import Common.Commands.ConsoleCommand;
import Common.Utilities.CommandUtilities;
import DataBase.DataBase;
import Main.Main;
import Selector.Selector;

import java.io.IOException;
import java.util.ArrayList;

public class TUI {
    final public static String[] MainCommandsM = {
        "help",
        "info",
        "get",
        "discard",
        "read",
        "exit",
    };

    public static Selector selector;
    public static DataBase.Statuses DBStatus;

    private enum arg {
        command,
        arg1,   arg2,   arg3,
        arg4,   arg5,   arg6,
        arg7,   arg8,   arg9
    }
    public TUI() {
        selector = new Selector();
        DBStatus = DataBase.Statuses.disconnected;
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
                Main.logger.log("Invalid command:" + exception.getMessage());
                //------------------------------------------
                //Main.logger.sendMessage("Invalid command:" + exception.getMessage());
            }
            catch (IllegalArgumentException exception) {
                System.out.println("Invalid argument\n");
                Main.logger.log("Invalid argument: " + exception.getMessage());
            }
            catch (IOException exception) {
                System.out.println("File Error: " + exception.getMessage() + "\n");
                Main.logger.log("File Error: " + exception.getMessage());
            }
        }
    }
}
