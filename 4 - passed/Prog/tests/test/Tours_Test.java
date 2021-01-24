import Selector.Selector;
import Tours.Tour;
import UI.TUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.HashSet;

public class Tours_Test {
    String Test1_path = "D:\\Labs\\2 - Applycation programming\\4\\Prog\\test1.txt";

    String[] types = {
        "Cruise",
        "Excursion",
        "Shopping",
        "Treatment",
        "Recreation"
    };

    @Test
    public void testCtor() {
        for(var type : types) {
            String ClassName = "Tours." + type;
            Tour newTour;
            try {
                Class<?> NewCommandC = Class.forName(ClassName);
                Constructor<?> NewCommandCtor = NewCommandC.getConstructor(String.class);
                newTour = ((Tour) NewCommandCtor.newInstance("Fucker"));
            }
            catch (Exception e) {
                Assertions.assertFalse(true);
                return;
            }
        }
    }

    @Test
    public void testToString() {
        TUI.selector = new Selector();
        try {
            TUI.selector.connect(Test1_path);
            TUI.selector.read();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
        try {
            HashSet<Tour> it = TUI.selector.getAll();
            for (var a: it) {
                a.toString();
            }
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
    }
}
