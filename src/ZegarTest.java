import org.junit.jupiter.api.Test;

public class ZegarTest {
    @Test
    public void angleTest() {
        Zegar.getAngle(3, 15).equals("7.5");
        Zegar.getAngle(12, 12).equals("66");
        Zegar.getAngle(96, 25).equals("Błędne dane");
        Zegar.getAngle(12, 90).equals("Błędne dane");
    }
}
