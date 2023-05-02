package items;

public class PatronusTest {
    public static void main(String[] args) {
        testGetName();
        testGetStrength();
    }

    private static void testGetName() {
        Patronus patronus = new Patronus("Expecto Patronum", 50);
        String expectedName = "Expecto Patronum";
        String actualName = patronus.getName();
        assert expectedName.equals(actualName) : "Expected: " + expectedName + ", but got: " + actualName;
    }

    private static void testGetStrength() {
        Patronus patronus = new Patronus("Expecto Patronum", 50);
        int expectedStrength = 50;
        int actualStrength = patronus.getStrength();
        assert expectedStrength == actualStrength : "Expected: " + expectedStrength + ", but got: " + actualStrength;
    }
}
