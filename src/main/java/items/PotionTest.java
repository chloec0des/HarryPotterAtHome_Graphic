package items;

import characters.Wizard;

public class PotionTest {
    public static void main(String[] args) {
        testUse();
        System.out.println("All tests passed!");
    }

    public static void testUse() {
        Wand wand = new Wand(Core.PHOENIX_FEATHER, 5);
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, wand, Pet.CAT);
        Potion potion = new Potion(30);
        int initialHp = wizard.getHealthPoints();
        potion.use(wizard);
        int newHp = wizard.getHealthPoints();

        assert newHp == initialHp + 30 : "Potion use did not heal the wizard's health points.";
    }
}

