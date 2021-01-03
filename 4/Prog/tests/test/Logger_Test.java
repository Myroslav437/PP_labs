import Logger.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Logger_Test {
    @Test
    public void testLog() {
        Logger lg = new Logger();
        try {
            lg.log("Test log");
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
    }

    @Test
    public void testSendMessage() {
        Logger lg = new Logger();
        try {
            lg.sendMessage("Test log UwU");
        }
        catch (Exception e) {
            Assertions.assertFalse(true);
            return;
        }
    }
}
