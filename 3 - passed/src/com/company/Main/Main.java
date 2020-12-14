package com.company.Main;

import com.company.Common.Command;
import com.company.Common.ConsoleUtilities;
import com.company.Lobby.Lobby;
import com.company.Droids.DroidHub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    final private static String[] MainCommandsM = {
        "help",
        "info",
        "lobby",
        "exit",
    };

    final private static Command[] MainCommandsF = {
        new Command() { public Integer Run(ArrayList<String> args) { return _Help_(args);  } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Info_(args);  } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Lobby_(args);  } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Exit_(args);  } },
    };

    public static void main(String[] args) {

        System.out.println("\t\tDroid battle game.");
        System.out.println("Get stuck? Use \"help\" command.");

        // Main cycle:
        while (true) {
            System.out.println("Waiting for your command: ");
            // Read command from the console:
            Scanner Cmd = new Scanner(System.in);
            String Input = Cmd.nextLine();
            if(Input.isBlank() || Input.equals("\n")) {
                continue;
            }
            StringTokenizer Tok = new StringTokenizer(Input);

            // Form the command:
            String Command = Tok.nextToken();
            ArrayList<String> Arg = new ArrayList<String>();
            while (Tok.hasMoreTokens()){
                Arg.add(Tok.nextToken());
            }

            if(Command.equals("\n") || Command.equals("")) {

            }

            // Run given command:
            for(int i = 0; i < MainCommandsM.length; ++i) {
                if(Command.equals(MainCommandsM[i])){
                    try{
                        MainCommandsF[i].Run(Arg);
                    }
                    catch (Exception e){};
                    break;
                }
                else if(i == MainCommandsM.length - 1) {
                    System.out.println("Command not found.");
                    System.out.println("Get stuck? Use \"help\" command.");
                }
            }

            continue;
        }
    }

    public static Integer _Help_(ArrayList<String> args){
        try {
            File InfoFile = new File("D:\\Labs\\Applycation programming\\3 - passed\\src\\com\\company\\Main\\Rules.txt");
            //File InfoFile = new File("Rules.txt");
            Scanner myReader = new Scanner(InfoFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            return 0;
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return 1;
        }
    }

    public static Integer _Info_(ArrayList<String> args){
        try {
            var type = args.get(0);
            if(DroidHub.isDroidType(type)) {
                System.out.println(type + ":");
                System.out.println(DroidHub.getDroidInfo(type));
            }
            else {
                System.out.println("Invalid droid type");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid \"info [droid_type]\" command call");
        }
        return 0;
    }

    private static Integer _Lobby_(ArrayList<String> args){
        Lobby MyLobby = new Lobby();
        var returnVal = MyLobby.Enter();
        System.out.println("Press any button to continue");
        new java.util.Scanner(System.in).nextLine();

        ConsoleUtilities.clear();
        System.out.println("\t\tDroid battle game.");
        System.out.println("Get stuck? Use \"help\" command.");

        return returnVal;
    }

    public static Integer _Exit_(ArrayList<String> args){
        System.out.println("Terminating the game...");
        System.exit(0);
        return 0;
    }
}
