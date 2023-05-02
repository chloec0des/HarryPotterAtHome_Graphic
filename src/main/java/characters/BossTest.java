package characters;

public class BossTest {

    public void testGetName() {
        Boss boss = new Boss("Ganon", 50, 200);

        String actualName = boss.getName();
        String expectedName = "Ganon";

        assertEquals(expectedName, actualName);
    }

    private void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected: %s, Actual: %s", expected, actual));
        }else {
            System.out.println("Tests completed successfully.");
        }
    }

    public static void main(String[] args) {
        BossTest test = new BossTest();
        test.testGetName();

    }

}
