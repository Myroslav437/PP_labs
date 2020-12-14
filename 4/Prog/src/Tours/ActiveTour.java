package Tours;
import java.util.ArrayList;

public abstract class ActiveTour extends Tour {
    ArrayList<String> EatingNames;
    ArrayList<Integer> EatingPrices;
    ArrayList<String> Places;

    ActiveTour(String name, Integer price, Integer period) {
        super(name, price, period);
        EatingNames = new ArrayList<String>();
        EatingPrices = new ArrayList<Integer>();
        return;
    }

    ActiveTour(String name, Integer price) {
        this(name, price, 0);
        return;
    }

    ActiveTour(String name) {
        this(name, 0, 0);
    }

    public void addEating(String name, Integer price) {
        EatingNames.add(name);
        EatingPrices.add(price);
        return;
    }

    public void addPlace(String place) {
        Places.add(place);
        return;
    }

    public ArrayList<String> getEatingNames() {
        return EatingNames;
    }

    public void setEatingNames(ArrayList<String> eatingNames) {
        EatingNames.addAll(eatingNames);
    }

    public ArrayList<Integer> getEatingPrices() {
        return EatingPrices;
    }

    public void setEatingPrices(ArrayList<Integer> eatingPrices) {
        EatingPrices.addAll(eatingPrices);
    }

    public ArrayList<String> getPlaces() {
        return Places;
    }

    public void setPlaces(ArrayList<String> places) {
        Places.addAll(places);
    }

    @Override
    public boolean customTerm() {
        return false;
    }

}
