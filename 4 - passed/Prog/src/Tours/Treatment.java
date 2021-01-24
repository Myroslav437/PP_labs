package Tours;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Treatment extends PassiveTour{
    public Treatment(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
    }

    public Treatment(String name, Integer basicPrice) {
        this(name, basicPrice, 0,0);
    }

    public Treatment(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities
    @Override
    public boolean customFood() {return false;};

    // ToString:
    @Override
    public String toString() {
        String res = super.toString();
        res =   res +
                "\tCustom food:\t" + "false\n";

        return res;
    }
}
