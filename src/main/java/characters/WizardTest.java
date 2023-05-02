package characters;

import items.*;

public class WizardTest {
    public static void main(String[] args) {
        WizardTest test = new WizardTest();
        test.testAttackEnemy();
    }
    public void testAttackEnemy() {
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, new Wand(Core.PHOENIX_FEATHER, 10), Pet.OWL);
        Enemy enemy = new Enemy("Draco Malfoy", 20, 80);
        Spell spell = new Spell("Stupefy", 50, 70);

        wizard.attackEnemy(enemy, spell);

        assertEquals(30, enemy.getHealthPoints());
    }

    private void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected: %d, Actual: %d", expected, actual));
        } else {
            System.out.println("Test passed!");
        }
    }

}
