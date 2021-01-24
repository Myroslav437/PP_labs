package Tours;

public abstract class ActiveTour extends Tour {
    ActiveTour(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        return;
    }

    ActiveTour(String name, Integer basicPrice) {
        this(name, basicPrice, 0, 0);
        return;
    }

    ActiveTour(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities
    @Override
    public boolean customTerm() {
        return false;
    }

    // ToString:
    @Override
    public String toString() {
        return  super.toString() +
                "\tCustom term:\t" + "false\n";
    }
}
