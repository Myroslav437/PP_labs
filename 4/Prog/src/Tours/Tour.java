package Tours;

import java.util.HashMap;
import java.util.Objects;

public abstract class Tour {
    private String  Name;
    private Integer PricePerDay;
    private Integer Term;
    private Integer BasicPrice; /////////////////////////

    /*--------------------------------------*/
    /*             Constructors:            */
    /*--------------------------------------*/

    Tour(String name, Integer basicPrice, Integer pricePerDay, Integer term) {
        Name = name;
        BasicPrice = basicPrice;
        PricePerDay = pricePerDay;
        Term = term;
    }

    Tour(String name, Integer basicPrice) {
        this(name, basicPrice, 0, 0);
    }

    Tour(String name) {
        this(name, 0, 0, 0);
        return;
    }

    Tour() {
        this("", 0, 0, 0);
        return;
    }

    // Basic functions:
    public String getName() {
        return Name;
    }
    public Integer getTerm() { return Term;};
    public void setTerm(Integer term) { Term = term; };
    public void setPricePerDay(Integer pricePerDay) { PricePerDay = pricePerDay;};
    public Integer getPricePerDay() {return PricePerDay; };
    public Integer getBasicPrice() { return BasicPrice; }
    public void setBasicPrice(Integer price) {BasicPrice = price;}

    //  Hashcode and Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Name.equals(tour.Name) &&
                PricePerDay.equals(tour.PricePerDay) &&
                Term.equals(tour.Term) &&
                BasicPrice.equals(tour.BasicPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, PricePerDay, Term, BasicPrice);
    }

    // Food:
    public abstract boolean customFood();
    public void addFood(String name, Integer price)         {}
    public HashMap<String, Integer> getFood()                   {return new HashMap<String, Integer>();}
    public void setFood(HashMap<String, Integer> food)          {}

    // Places:
    public abstract boolean customPlaces();
    public void addPlace(String place, Integer price)       {}
    public HashMap<String, Integer> getPlaces()                 {return new HashMap<String, Integer>();}
    public void setPlaces(HashMap<String, Integer> places)      {}

    // Transport
    public abstract boolean customTransport();
    public void addTransport(String name, Integer price)    {};
    public HashMap<String, Integer> getTransport()              {return new HashMap<String, Integer>();};
    public void setTransport(HashMap<String, Integer> transport){};

    // Terms:
    public abstract boolean customTerm();

    // ToString:

    @Override
    public String toString() {
        String type = this.getClass().getName();
        Integer idx = type.indexOf('.');
        type = type.substring(idx + 1, type.length());
        return   type + " " + Name + ":\n" +
                "\tBasicPrice:\t"  + BasicPrice.toString() + "\n" +
                "\tPricePerDay:\t" + PricePerDay.toString() + "\n" +
                "\tTerm:\t" + Term.toString() + "\n";
    }
}
