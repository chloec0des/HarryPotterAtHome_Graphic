package items;

public class AbstractSpellTest {

    public static void main(String[] args) {

        // create an instance of the abstract class
        AbstractSpell spell = new AbstractSpell("Fireball", 30.0, 0.75) {};

        // test getName()
        String name = spell.getName();
        if (!name.equals("Fireball")) {
            System.out.println("Error: getName() returned " + name + ", expected Fireball");
        }

        // test getDamage()
        double damage = spell.getDamage();
        if (damage != 30.0) {
            System.out.println("Error: getDamage() returned " + damage + ", expected 30.0");
        }

        // test getAccuracy()
        double accuracy = spell.getAccuracy();
        if (accuracy != 0.75) {
            System.out.println("Error: getAccuracy() returned " + accuracy + ", expected 0.75");
        }

        // test setDamage()
        spell.setDamage(40.0);
        damage = spell.getDamage();
        if (damage != 40.0) {
            System.out.println("Error: setDamage() did not update the damage value correctly");
        }

        // test setAccuracy()
        spell.setAccuracy(0.85);
        accuracy = spell.getAccuracy();
        if (accuracy != 0.85) {
            System.out.println("Error: setAccuracy() did not update the accuracy value correctly");
        }

        System.out.println("All tests passed!");
    }
}
