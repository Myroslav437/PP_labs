package Common.Utilities;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CommandUtilities {
    public static ArrayList<String> GetTokCommand() throws IllegalArgumentException {
        // Read command from the console:
        String Input = new Scanner(System.in).nextLine();
        if(Input.isBlank() || Input.equals("\n")) {
            throw new IllegalArgumentException("Empty command");
        }

        ArrayList<String> result = new ArrayList<String>();
        StringTokenizer Tok = new StringTokenizer(Input);

        // Form the command:
        while (Tok.hasMoreTokens()){
            result.add(Tok.nextToken());
        }

        return result;
    }

    public static String GetCommand() throws IllegalArgumentException {
        // Read command from the console:
        String Input = new Scanner(System.in).nextLine();
        if(Input.isBlank() || Input.equals("\n")) {
            throw new IllegalArgumentException("Empty command");
        }

        return Input;
    }

    public static String FormCommandClassName(String command) {
        String res;
        command.toLowerCase();
        command.replace(' ', '_');
        res = command.substring(0, 1).toUpperCase() + command.substring(1) + "Command";

        return res;
    }
}
