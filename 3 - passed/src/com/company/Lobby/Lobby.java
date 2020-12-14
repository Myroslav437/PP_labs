package com.company.Lobby;

//import com.company.Arena.Arena;
import com.company.Arena.Arena;
import com.company.Common.Command;
import com.company.Droids.Droid;
import com.company.Common.ConsoleUtilities;
import com.company.Droids.DroidHub;
import com.company.Main.Main;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lobby {
    final private static String[] LobbyCommandsM = {
        "add",
        "remove",
        "list",
        "start",
        "exit",
        "help",
        "info",
    };

    final private static Command[] LobbyCommandsF = {
        new Command() { public Integer Run(ArrayList<String> args) { return _Add_(args);    } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Remove_(args); } },
        new Command() { public Integer Run(ArrayList<String> args) { return _List_(args);   } },
        new Command() { public Integer Run(ArrayList<String> args) throws Exception { return _Start_(args);  } },
        new Command() { public Integer Run(ArrayList<String> args) throws Exception { return _Exit_(args);   } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Help_(args);   } },
        new Command() { public Integer Run(ArrayList<String> args) { return _Info_(args);   } },
    };

    protected static ArrayList<ArrayList<Droid>> TeamDroids;
    protected static ArrayList<String> TeamNames;


    public Lobby() {
        TeamDroids = new ArrayList<ArrayList<Droid>>();
        TeamNames = new ArrayList<String>();
    }


    public Integer Enter() {
        // Clear console:
        ConsoleUtilities.clear();
        System.out.println("\t\tLobby.");

        // Enter Team names, create appropriate droid containers:
        for(Integer i = 0; i < 2; ++i) {
            System.out.println("Enter Team " + ((Integer)(i + 1)).toString() + " name: ");
            TeamNames.add((new Scanner(System.in)).nextLine());
            TeamDroids.add(new ArrayList<Droid>());
        }

        // Lobby cycle:
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

            // Run given command:
            for(int i = 0; i < LobbyCommandsM.length; ++i) {
                if(Command.equals(LobbyCommandsM[i])){
                    try {
                        LobbyCommandsF[i].Run(Arg);
                    }
                    catch (Exception e) { // Exit command:
                        return 0;
                    };

                    break;
                }
                else if(i == LobbyCommandsM.length - 1) {
                    System.out.println("Command not found.");
                    System.out.println("Get stuck? Use \"help\" command.");
                }
            }

            continue;
        }
    }

    private static Integer _Add_ (ArrayList < String > args) {
        try {
            // Extract arguments:
            String Team = args.get(0);
            String DroidType = args.get(1);
            String DroidName = args.get(2);

            // Create a new droid:
            Droid BrandNewDroid = DroidHub.createDroid(DroidType, DroidName);
            if(BrandNewDroid == null) {
                System.out.println("Invalid droid type");
                return 1;
            }

            // Assign new droid to a team:
            for(int i = 0; i < TeamNames.size(); ++i) {
                if(TeamNames.get(i).equals(Team)) {
                    TeamDroids.get(i).add(BrandNewDroid);
                    return 0;
                }
                else if(i == TeamNames.size() - 1) {
                    System.out.println("Invalid team name");
                    return 1;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid \"add [team] [type] [name]\" command call");
            return 1;
        }

        return 0;
    }

    private static Integer _Remove_ (ArrayList < String > args) {
        try {
            String team = args.get(0);
            String name = args.get(1);

            for(int i = 0; i < TeamNames.size(); ++i) {
                if (TeamNames.get(i).equals(team)) {
                    for (int j = 0; j < TeamDroids.get(i).size(); ++j) {
                        if (name.equals(TeamDroids.get(i).get(j).getName())) {
                            TeamDroids.get(i).remove(TeamDroids.get(i).get(j));
                            return 0;
                        }
                        else if(j == TeamDroids.get(i).size() - 1) {
                            System.out.println("There is no droids with " + name + " name");
                            return 1;
                        }
                    }
                }
                else if(i == TeamNames.size() - 1) {
                    System.out.println("Invalid team name");
                    return 1;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid \"remove [team] [name]\" command call");
            return 1;
        }

        return 0;
    }

    private static Integer _List_ (ArrayList < String > args) {
        try {
            String team = args.get(0);

            for(int i = 0; i < TeamNames.size(); ++i) {
                if(TeamNames.get(i).equals(team)) {
                    for(var a: TeamDroids.get(i)){
                        System.out.println(DroidHub.getDroidType(a) + "\t" + a.getName());
                    }
                    return 0;
                }
                else if (i == TeamNames.size() - 1) {
                    System.out.println("Invalid team name");
                    return 1;
                }
            }
        }
        catch (Exception e){
            System.out.println("Invalid \"list [team]\" command call");
            return 1;
        }

        return 0;
    }

    private static Integer _Start_ (ArrayList < String > args) throws NotActiveException {
        Arena match = new Arena(TeamNames, TeamDroids);
        match.RunBattle();
        _Exit_(args);
        return 0;
    }

    private static Integer _Exit_ (ArrayList < String > args) throws NotActiveException {
        throw new NotActiveException(new String(""));
    }

    private static Integer _Help_ (ArrayList < String > args) {
        Main._Help_(args);
        return 0;
    }

    private static Integer _Info_ (ArrayList < String > args) {
        Main._Info_(args);
        return 0;
    }
}
