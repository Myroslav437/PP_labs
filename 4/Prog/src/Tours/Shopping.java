package Tours;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Shopping extends ActiveTour {
    private HashMap<String, Integer> Food;
    private HashMap<String, Integer> Transport;

    public Shopping(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        Transport = new HashMap<String, Integer>();
        Food = new HashMap<String, Integer>();
    }

    public Shopping(String name, Integer basicPrice) {
        this(name, basicPrice, 0,0);
    }

    public Shopping(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities:
    @Override
    public boolean customTransport() {
        return true;
    }
    @Override
    public boolean customFood() {
        return true;
    }
    @Override
    public boolean customPlaces() {
        return false;
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

    // Transport:
    @Override
    public void addTransport(String name, Integer price) {
        Transport.put(name, price);
    }
    @Override
    public void setTransport(HashMap<String, Integer> transport) {
        Transport = transport;
    }
    @Override
    public HashMap<String, Integer> getTransport() {
        return Transport;
    }

    // ToString:
    @Override
    public String toString() {
        String res = super.toString();
        res = res +
                "\tCustom transport:\t" + "true\n" +
                "\tCustom food:\t" + "true\n" +
                "\tCustom places:\t" + "false\n";

        res += "\tTransport:\n";
        {
            Iterator<Map.Entry<String, Integer>> it = Transport.entrySet().iterator();
            // iterating every set of entry in the HashMap.
            while (it.hasNext()) {
                res += "\t\t";
                Map.Entry<String, Integer> set = (Map.Entry<String, Integer>) it.next();
                res += set.getKey() + ": \t" + set.getValue() + "\n";
            }
        }

        res += "\tFood:\n";
        {
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
