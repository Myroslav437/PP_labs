package Tours;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excursion extends ActiveTour {
    HashMap<String, Integer> Transport;

    public Excursion(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        Transport = new HashMap<String, Integer>();
    }

    public Excursion(String name, Integer basicPrice) {
        this(name, basicPrice, 0,0);
    }

    public Excursion(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities:
    @Override
    public boolean customTransport() {
        return true;
    }
    @Override
    public boolean customFood() {
        return false;
    }
    @Override
    public boolean customPlaces() {
        return false;
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
                "\tCustom food:\t" + "false\n" +
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

        return res;
    }
}
