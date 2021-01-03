import Common.Utilities.ConsoleUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Other_Test {
    @Test
    public void testClear() {
        try {
            ConsoleUtilities.clear();
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }

    }
}
