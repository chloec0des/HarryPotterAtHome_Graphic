package items;

public class WandTest {

    public static void main(String[] args) {
        testWand();
    }

    private static void testWand() {
        // Test case 1
        Wand wand1 = new Wand(Core.PHOENIX_FEATHER, 5);
        assert wand1.getCore() == Core.PHOENIX_FEATHER : "Test case 1: Failed - Core mismatch";
        assert wand1.getSize() == 5 : "Test case 1: Failed - Size mismatch";

        // Test case 2
        Wand wand2 = new Wand(Core.DRAGON_HEARTSTRING, 10);
        assert wand2.getCore() == Core.DRAGON_HEARTSTRING : "Test case 2: Failed - Core mismatch";
        assert wand2.getSize() == 10 : "Test case 2: Failed - Size mismatch";

        System.out.println("All test cases passed.");
    }
}

