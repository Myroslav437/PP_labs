package Tours;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cruise extends ActiveTour {
    HashMap<String, Integer> Food;
    HashMap<String, Integer> Places;

    public Cruise(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        Places = new HashMap<String, Integer>();
        Food = new HashMap<String, Integer>();
    }

    public Cruise(String name, Integer basicPrice) {
        this(name, basicPrice, 0,0);
    }

    public Cruise(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities:
    @Override
    public boolean customTransport() {
        return false;
    }
    @Override
    public boolean customFood() {
        return true;
    }
    @Override
    public boolean customPlaces() {
        return true;
    }

    // Food:
    @Override
    public void addFood(String name, Integer price) {
        Food.put(name, price);
        return;
    }
    @Override
    public HashMap<String, Integer> getFood() {
        return Food;
    }
    @Override
    public void setFood(HashMap<String, Integer> food) {
        Food = food;
    }

    // Places:
    @Override
    public void addPlace(String place, Integer price) {
        Places.put(place, price);
        return;
    }
    @Override
    public HashMap<String, Integer> getPlaces() {
        return Places;
    }
    @Override
    public void setPlaces(HashMap<String, Integer> places) {
        Places = places;
    }

    // ToString:
    @Override
    public String toString() {
        String res = super.toString();
        res =   res +
                "\tCustom transport:\t" + "false\n" +
                "\tCustom food:\t" + "true\n" +
                "\tCustom places:\t" + "true\n";

        res += "\tFood:\n"; {
            Iterator<Map.Entry<String, Integer>> it = Food.entrySet().iterator();
            // iterating every set of entry in the HashMap.
            while (it.hasNext()) {
                res += "\t\t";
                Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                res += set.getKey() + ": \t" + set.getValue() + "\n";
            }
        }

        res += "\tPlaces:\n"; {
            Iterator<Map.Entry<String, Integer>> it = Places.entrySet().iterator();
            // iterating every set of entry in the HashMap.
            while (it.hasNext()) {
                res += "\t\t";
                Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                res += set.getKey() + ": \t" + set.getValue() + "\n";
            }
        }

        return res;
    }
}
