import Common.Commands.ConsoleCommand;
import Common.Utilities.CommandUtilities;
import Selector.Selector;
import UI.TUI;
import UI.UICommandFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Command_Test {
    String Test1_path = "D:\\Labs\\2 - Applycation programming\\4\\Prog\\test1.txt";

    @Test
    public void testHelp() {
        // Run given command:
        String ClassName = "UI." + CommandUtilities.FormCommandClassName("help");
        try {
            // Create new command:
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, new ArrayList<>());
            // Run command:
            String res = BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
    }

    @Test
    public void testGet1() {
        // Run given command:
        String ClassName = "UI." + CommandUtilities.FormCommandClassName("get");
        try {
            TUI.selector = new Selector();
            try {
                TUI.selector.connect(Test1_path);
                TUI.selector.read();
            }
            catch (Exception e) {
                Assertions.assertFalse(true);
                return;
            }
            // Create new command:
            ArrayList<String> args = new ArrayList<>();
            args.add("food");
            args.add("below");
            args.add("100");
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            // Run command:
            String res = BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
    }

    public void testComplex1() {
        // read:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("read");
            ArrayList<String> args = new ArrayList<>();
            args.add(Test1_path);
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

        // get All:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("get");
            ArrayList<String> args = new ArrayList<>();
            args.add("all");
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

        // get basic price over 500:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("get");
            ArrayList<String> args = new ArrayList<>();
            args.add("b_price");
            args.add("over");
            args.add("500");
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

        // discard:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("discard");
            ArrayList<String> args = new ArrayList<>();
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

        // get term below 14:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("get");
            ArrayList<String> args = new ArrayList<>();
            args.add("days");
            args.add("below");
            args.add("14");
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

        // get transport below 50:
        try {
            String ClassName = "UI." + CommandUtilities.FormCommandClassName("get");
            ArrayList<String> args = new ArrayList<>();
            args.add("transport");
            args.add("below");
            args.add("50");
            ConsoleCommand BrandNewCommand = UICommandFactory.createConsoleCommand(ClassName, args);
            BrandNewCommand.Run();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

    }
}
