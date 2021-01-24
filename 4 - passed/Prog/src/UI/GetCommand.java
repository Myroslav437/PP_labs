package UI;
import Common.Commands.ConsoleCommand;
import Common.Commands.StringCommand;
import Tours.Tour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class GetCommand extends ConsoleCommand{
    final private static String[] TourParams = new String[] {
        "all",
        "b_price",
        "transport",
        "food",
        "days",
    };

    private static StringCommand[] TourParamsF = new StringCommand[] {
        new StringCommand() { public String  Run(ArrayList<String> arg) throws IOException { return All_(arg); } },
        new StringCommand() { public String  Run(ArrayList<String> arg) throws IOException { return B_price_(arg); } },
        new StringCommand() { public String  Run(ArrayList<String> arg) throws IOException { return Transport_(arg); } },
        new StringCommand() { public String  Run(ArrayList<String> arg) throws IOException { return Food_(arg); } },
        new StringCommand() { public String  Run(ArrayList<String> arg) throws IOException { return Days_(arg); } },
    };

    final private static String[] getCommandArgsMod = new String[] {
        "below",
        "over",
        "editable",
        "not_editable",
    };

    public GetCommand(ArrayList<String> args) {
        super(args);
    }

    @Override
    public String Run() throws ClassNotFoundException, IOException{
        for(int i = 0; i < TourParams.length; ++i) {
            if(TourParams[i].equals(super.arguments.get(0))) {
                super.arguments.remove(0);
                try {
                    return TourParamsF[i].Run(super.arguments);
                }
                catch (IndexOutOfBoundsException e) {
                    throw new IllegalArgumentException("Invalid argument");
                }
            }
        }

        throw new ClassNotFoundException("Can't find such command");
    }

    @Override
    public String GetInfo() {
        return "Command signature: \"get [parameter, specifier, value]\" or \"get [void]\".\n" +
               "1) This command applies given filter to the tours.\n" +
               "   Reusing the command imposes the new filter on the previously shown sample\n" +
               "2) \"get\" command with no parameters shows tours with current filter\n" +
               "To cancel applied filters use \"discard\" command";
    }

    private static String All_(ArrayList<String>  cmd) throws IOException {
        String res = "";
        HashSet tours = TUI.selector.getAll();
        res += formResult(tours);

        return res;
    }

    private static String B_price_(ArrayList<String>  cmd) throws IOException{
        String res = "";
        HashSet<Tour> tours;

        String arg1 = cmd.get(0);
        Integer arg2 = Integer.parseInt(cmd.get(1));
        switch (arg1) {
            case("below"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){return t.getBasicPrice() <= arg2;}}); break;
            case("over"): tours =  TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){return t.getBasicPrice() >= arg2;}}); break;
            case("editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){return false;}}); break;
            case("not-editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){return true;}}); break;
            default: throw new IllegalArgumentException("Invalid b_price argument");
        }
        res += formResult(tours);

        return res;
    }

    private static String Transport_(ArrayList<String>  cmd) throws IOException {
        String res = "";
        HashSet<Tour> tours;

        String arg1 = cmd.get(0);
        switch (arg1) {
            case("below"): tours =    TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                Integer arg2 = Integer.parseInt(cmd.get(1));
                Iterator<Map.Entry<String, Integer>> it = t.getTransport().entrySet().iterator();
                // iterating every set of entry in the HashMap.
                while (it.hasNext()) {
                    Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                    if(set.getValue() <= arg2){
                        return  true;
                    }
                }
                return  false;}}); break;
            case("over"): tours =     TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                Integer arg2 = Integer.parseInt(cmd.get(1));
                Iterator<Map.Entry<String, Integer>> it = t.getTransport().entrySet().iterator();
                // iterating every set of entry in the HashMap.
                while (it.hasNext()) {
                    Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                    if(set.getValue() >= arg2){
                        return  true;
                    }
                }
                return  false;}}); break;
            case("editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return t.customTransport();
            }}); break;
            case("not-editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return !(t.customTransport());
            }}); break;
            default: throw new IllegalArgumentException("Invalid b_price argument");
        }
        res += formResult(tours);

        return res;
    }

    private static String Food_(ArrayList<String>  cmd) throws IOException {
        String res = "";
        HashSet<Tour> tours;

        String arg1 = cmd.get(0);
        switch (arg1) {
            case("below"): tours = TUI.selector.getIf(new Predicate<Tour>(){
                public boolean test(Tour t){
                    Integer arg2 = Integer.parseInt(cmd.get(1));
                    Iterator<Map.Entry<String, Integer>> it = t.getFood().entrySet().iterator();
                    // iterating every set of entry in the HashMap.
                    while (it.hasNext()) {
                        Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                        if(set.getValue() <= arg2){
                            return  true;
                        }
                    }
                    return  false;
                }
            }); break;
            case("over"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                Integer arg2 = Integer.parseInt(cmd.get(1));
                Iterator<Map.Entry<String, Integer>> it = t.getFood().entrySet().iterator();
                // iterating every set of entry in the HashMap.
                while (it.hasNext()) {
                    Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                    if(set.getValue() >= arg2){
                        return  true;
                    }
                }
                return  false;}}); break;
            case("editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return t.customFood();
            }}); break;
            case("not-editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return !(t.customFood());
            }}); break;
            default: throw new IllegalArgumentException("Invalid b_price argument");
        }
        res += formResult(tours);

        return res;
    }
    private static String Days_(ArrayList<String>  cmd) throws IOException {
        String res = "";
        HashSet<Tour> tours;

        String arg1 = cmd.get(0);
        switch (arg1) {
            case("below"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                Integer arg2 = Integer.parseInt(cmd.get(1));
                return t.customTerm() ? true : t.getTerm() <= arg2;
            }}); break;
            case("over"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                Integer arg2 = Integer.parseInt(cmd.get(1));
                return t.customTerm() ? true : t.getTerm() >= arg2;
            }}); break;
            case("editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return t.customTerm();
            }}); break;
            case("not-editable"): tours = TUI.selector.getIf(new Predicate<Tour>(){public boolean test(Tour t){
                return !(t.customTerm());
            }}); break;
            default: throw new IllegalArgumentException("Invalid b_price argument");
        }
        res += formResult(tours);

        return res;
    }

    private static String formResult(HashSet<Tour> tours) {
        String res = "";
        Iterator<Tour> it = tours.iterator();
        while(it.hasNext()){
            res += "---------------------------------------------------------------\n";
            res += it.next().toString() + "\n";
            res = res.substring(0, res.length() - 1);
            res += "---------------------------------------------------------------\n";
        }
        return res;
    }
}
