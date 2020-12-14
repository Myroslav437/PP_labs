package com.company.Arena;

import com.company.Droids.Droid;

import java.util.*;

public class Arena {

    protected static ArrayList<ArrayList<Droid>> TeamDroids;
    protected static ArrayList<String> TeamNames;

    public Arena(ArrayList<String> names, ArrayList<ArrayList<Droid>> droids) {
        TeamDroids = new ArrayList<ArrayList<Droid>>();
        TeamNames = new ArrayList<String>();
        TeamDroids.addAll(droids);
        TeamNames.addAll(names);
        return;
    }

    public int RunBattle() {
        Random CommonRand = new Random();
        int firstMove = CommonRand.nextInt(2);

        for(int CurrentTeam = firstMove; ; CurrentTeam = ++CurrentTeam % TeamNames.size()){
            System.out.println("\n Team " + TeamNames.get(CurrentTeam) + " move:\n");
            var CurrentDroids = TeamDroids.get(CurrentTeam);
            /* check on win */ {
                int AliveTeams = 0;
                int WinnerWinnerChickenDinner = -1;
                for(int Team = 0; Team < TeamDroids.size(); ++Team) {
                    if(HasAliveDroids(TeamDroids.get(Team))) {
                        ++AliveTeams;
                        WinnerWinnerChickenDinner = Team;
                    }
                }
                if(AliveTeams <= 1) {
                    System.out.println();
                    System.out.println("Team " + TeamNames.get(WinnerWinnerChickenDinner) + " is a winner!!!");
                    return 0;
                }
            }

            // Do some cleanup:
            for(final var Team : TeamDroids) {
                DeadStorage(Team);
            }

            // Make epic moves:
            for(int OpponentTeamIdx = 0; OpponentTeamIdx < TeamNames.size(); ++OpponentTeamIdx) {
                if(OpponentTeamIdx == CurrentTeam) {
                    continue;
                }
                var OpponentTeam = TeamDroids.get(OpponentTeamIdx);

                // Share support:
                for(var Support : TeamDroids.get(CurrentTeam)){
                    for(var Receiver : TeamDroids.get(CurrentTeam)) {
                        Integer ReceivedSupport = Support.sendSupport(Receiver);
                        if(ReceivedSupport != 0) {
                            System.out.println(Support.getName() + " supported " + Receiver.getName() + " with " + ReceivedSupport.toString() + " HP");
                            System.out.println("  >" + Receiver.getName() + " health is " + ((Integer)Receiver.getHealth()).toString());
                            break;
                        }
                    }
                }

                // Attack opponent team
                for(var Unit : TeamDroids.get(CurrentTeam)) {
                    // remove bodies)
                    for(final var Team : TeamDroids) {
                        DeadStorage(Team);
                    }
                    var randomOpponentDroid = OpponentTeam.get(CommonRand.nextInt(OpponentTeam.size()));
                    Integer dmg = randomOpponentDroid.receiveDamage(Unit);
                    System.out.println(Unit.getName() + " attacked "  +randomOpponentDroid.getName() + " with " +  dmg.toString() + " damage");
                    System.out.println("  >" + randomOpponentDroid.getName() + " health is " + ((Integer)randomOpponentDroid.getHealth()).toString());
                }
            }
        }
    }

    private boolean HasAliveDroids(ArrayList<Droid> DreamTeam) {
        for(final var Unit : DreamTeam) {
            if(Unit.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void DeadStorage(ArrayList<Droid> Droids) {
        int allNiggas = Droids.size();
        for(int niggaIdx = 0; niggaIdx < allNiggas; ++niggaIdx) {
            final var myNigga = Droids.get(niggaIdx);
            if(!myNigga.isAlive()) {
                Droids.remove(myNigga); // F
            }
            allNiggas = Droids.size();
        }
    }
}