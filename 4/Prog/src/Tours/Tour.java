package Tours;

import java.util.Objects;

public abstract class Tour {
    private String name;
    private Integer price;
    private Integer period;

    Tour(String name, Integer price, Integer period) {
        this.name = name;
        this.price = price;
        this.period = period;
    }

    Tour(String name, Integer price) {
        this(name, price, 0);
    }

    Tour(String name) {
        this(name, 0, 0);
        return;
    }

    public abstract boolean customTerm();
    public abstract boolean customTransport();
    public abstract boolean customEating();

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return name.equals(tour.name) &&
                price.equals(tour.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
