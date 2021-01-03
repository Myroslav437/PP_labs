import DataBase.DataBase;
import Tours.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

public class DataBase_Test {
    Tour t1, t2, t3, t4, t5;
    String Test1_path = "D:\\Labs\\2 - Applycation programming\\4\\Prog\\test1.txt";
    HashSet<Tour> tours;

    public DataBase_Test() {
        // Tour 1
        t1 = new Cruise("Bahamas");
        // Food
        t1.addFood("Econom", 500);
        t1.addFood("Econom_plus", 700);
        t1.addFood("Premium", 1000);
        // Places
        t1.addPlace("Atlantis_Paradise_Island", 100);
        t1.addPlace("Nassau", 150);
        t1.addPlace("Harbour_Island", 50);
        t1.addPlace("Andros_Island", 60);
        // Term
        t1.setTerm(15);
        // Basic Price
        t1.setBasicPrice(1000);
        // Basic Price
        t1.setPricePerDay(67);

        // Tour 2
        t2 = new Recreation("Shatsk");
        // Food
        t2.addFood("Dietary", 10);
        t2.addFood("Vegetarian", 5);
        t2.addFood("Standart", 20);
        // Term
        t2.setTerm(14);
        // Basic Price
        t2.setBasicPrice(300);
        // Basic Price
        t2.setPricePerDay(21);

        // Tour 3
        t3 = new Excursion("Chernobyl");
        // Transport
        t3.addTransport("Regular_bus", 0);
        t3.addTransport("Comfort_bus", 20);
        t3.addTransport("Private_car", 50);
        // Term
        t3.setTerm(2);
        // Basic Price
        t3.setBasicPrice(200);
        // Basic Price
        t3.setPricePerDay(100);

        // Tour 4
        t4 = new Shopping("NewYork");
        // Food
        t4.addFood("Standart", 0);
        t4.addFood("Premium", 50);
        // Transport
        t4.addTransport("Bus", 10);
        t4.addTransport("Private_car", 30);
        // Term
        t4.setTerm(1);
        // Basic Price
        t4.setBasicPrice(50);
        // Basic Price
        t4.setPricePerDay(50);

        // Tour 5
        t5 = new Treatment("Medyk");
        // Term
        t5.setTerm(25);
        // Basic Price
        t5.setBasicPrice(500);
        // Basic Price
        t5.setPricePerDay(20);

        tours = new HashSet<>();
        tours.add(t1);
        tours.add(t2);
        tours.add(t3);
        tours.add(t4);
        tours.add(t5);
    }

    @Test
    public void testRead() {
        DataBase DB = new DataBase();
        try {
            DB.connect(Test1_path);
            DB.read();

        } catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
        Iterator<Tour> iterator1 = DB.getIterator();
        Iterator<Tour> iterator2 = tours.iterator();

        while (iterator1.hasNext()) {
            Assertions.assertEquals(iterator1.next(), iterator2.next());
        }
    }

}