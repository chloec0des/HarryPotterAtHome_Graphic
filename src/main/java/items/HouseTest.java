package items;

public class HouseTest {
    public static void main(String[] args) {
        // Test Gryffindor
        String actual = House.GRYFFINDOR.getName();
        String expected = "Gryffindor";
        assert actual.equals(expected) : "Expected " + expected + ", but got " + actual;

        // Test Slytherin
        actual = House.SLYTHERIN.getName();
        expected = "Slytherin";
        assert actual.equals(expected) : "Expected " + expected + ", but got " + actual;

        // Test Hufflepuff
        actual = House.HUFFLEPUFF.getName();
        expected = "Hufflepuff";
        assert actual.equals(expected) : "Expected " + expected + ", but got " + actual;

        // Test Ravenclaw
        actual = House.RAVENCLAW.getName();
        expected = "Ravenclaw";
        assert actual.equals(expected) : "Expected " + expected + ", but got " + actual;

        // All tests passed
        System.out.println("All tests passed.");
    }
}
