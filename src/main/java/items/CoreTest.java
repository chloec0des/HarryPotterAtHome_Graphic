package items;

public class CoreTest {
    public static void main(String[] args) {
        testGetName();
    }

    public static void testGetName() {
        Core core = Core.PHOENIX_FEATHER;
        String expectedName = "Phoenix feather";
        String actualName = core.getName();
        if (!actualName.equals(expectedName)) {
            System.out.println("testGetName failed: expected " + expectedName + ", but got " + actualName);
        } else {
            System.out.println("testGetName passed");
        }
    }
}
