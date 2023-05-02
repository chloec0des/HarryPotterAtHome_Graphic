package items;

public class SpellTest {

    public static void main(String[] args) {
        // Test the constructor and getter methods
        testSpellConstructorAndGetters();
    }

    private static void testSpellConstructorAndGetters() {
        String testName = "Fireball";
        double testDamage = 50.0;
        double testAccuracy = 0.8;

        Spell testSpell = new Spell(testName, testDamage, testAccuracy);

        if (!testSpell.getName().equals(testName)) {
            System.out.println("Failed: Spell name mismatch.");
        }

        if (testSpell.getDamage() != testDamage) {
            System.out.println("Failed: Spell damage mismatch.");
        }

        if (testSpell.getAccuracy() != testAccuracy) {
            System.out.println("Failed: Spell accuracy mismatch.");
        }

        System.out.println("Finished testing Spell constructor and getters.");
    }
}
