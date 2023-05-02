package items;

public class SwordTest {

    public static void main(String[] args) {
        // Test constructor
        Sword sword = new Sword("Excalibur", 50);

        // Test getName from the superclass Item
        if (!sword.getName().equals("Excalibur")) {
            System.out.println("Test failed: Expected name 'Excalibur' but got '" + sword.getName() + "'");
        } else {
            System.out.println("Test passed: getName");
        }

        // Test getDamage
        if (sword.getDamage() != 50) {
            System.out.println("Test failed: Expected damage '50' but got '" + sword.getDamage() + "'");
        } else {
            System.out.println("Test passed: getDamage");
        }

        // Test setDamage
        sword.setDamage(75);
        if (sword.getDamage() != 75) {
            System.out.println("Test failed: Expected updated damage '75' but got '" + sword.getDamage() + "'");
        } else {
            System.out.println("Test passed: setDamage");
        }
    }
}
