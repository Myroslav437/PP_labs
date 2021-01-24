package Tours;

public abstract class PassiveTour extends Tour {
    PassiveTour(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        super(name, basicPrice, pricePerDay, term);
        return;
    }

    PassiveTour(String name, Integer basicPrice) {
        this(name, basicPrice, 0, 0);
        return;
    }

    PassiveTour(String name) {
        this(name, 0, 0, 0);
    }

    // Peculiarities:
    @Override
    public boolean customPlaces() { return false; }
    @Override
    public boolean customTransport() { return  false; }
    @Override
    public boolean customTerm() { return true;}

    // ToString():
    @Override
    public String toString() {
        String res = super.toString();
        res +=
            "\tCustom places:\t" + "false\n" +
            "\tCustom transport:\t" + "false\n" +
            "\tCustom term:\t" + "true\n";

        return res;
    }
}
