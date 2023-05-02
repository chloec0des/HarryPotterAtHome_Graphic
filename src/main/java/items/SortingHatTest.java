package items;

public class SortingHatTest {
    public static void main(String[] args) {
        testRandomHouse();
    }

    public static void testRandomHouse() {
        SortingHat sortingHat = new SortingHat();

        System.out.println("Testing randomHouse() method:");
        for (int i = 0; i < 10; i++) {
            House house = sortingHat.randomHouse();
            System.out.println("House #" + (i + 1) + ": " + house);
        }
    }
}
