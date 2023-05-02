package items;

public class PetTest {

    public static void main(String[] args) {
        testPetGetName();
    }

    private static void testPetGetName() {
        boolean testPassed = true;

        if (!Pet.OWL.getName().equals("Owl")) {
            System.out.println("FAIL: Pet.OWL.getName() should return 'Owl'");
            testPassed = false;
        }

        if (!Pet.RAT.getName().equals("Rat")) {
            System.out.println("FAIL: Pet.RAT.getName() should return 'Rat'");
            testPassed = false;
        }

        if (!Pet.CAT.getName().equals("Cat")) {
            System.out.println("FAIL: Pet.CAT.getName() should return 'Cat'");
            testPassed = false;
        }

        if (!Pet.TOAD.getName().equals("Toad")) {
            System.out.println("FAIL: Pet.TOAD.getName() should return 'Toad'");
            testPassed = false;
        }

        if (testPassed) {
            System.out.println("SUCCESS: All test cases for Pet.getName() passed.");
        } else {
            System.out.println("FAIL: Some test cases for Pet.getName() failed.");
        }
    }
}
