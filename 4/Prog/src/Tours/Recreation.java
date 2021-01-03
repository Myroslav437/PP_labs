package Tours;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Recreation extends PassiveTour{
    private HashMap <String, Integer> Food;

    public Recreation(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        Food = new HashMap<String, Integer>();
    }

    public Recreation(String name, Integer basicPrice) {
        this(name, basicPrice, 0,0);
    }

    public Recreation(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities
    @Override
    public boolean customFood() {return true;};

    // Food:
    @Override
    public void addFood(String name, Integer price) {
        Food.put(name, price);
    }
    @Override
    public HashMap<String, Integer> getFood() {
        return Food;
    }
    @Override
    public void setFood(HashMap<String, Integer> food) {
        Food = food;
    }

    // ToString:
    @Override
    public String toString() {
        String res = super.toString();
        res =   res +
                "\tCustom food:\t" + "true\n";

        res += "\tFood:\n"; {
            Iterator<Map.Entry<String, Integer>> it = Food.entrySet().iterator();
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
