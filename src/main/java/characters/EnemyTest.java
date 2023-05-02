package characters;

public class EnemyTest {
    public static void main(String[] args) {
        EnemyTest test = new EnemyTest();
        test.testTakeDamage();
    }
    public void testTakeDamage() {
        Enemy enemy = new Enemy("Test Enemy", 10, 100);

        enemy.takeDamage(20);

        assertEquals(80, enemy.getHealthPoints());
    }

    private void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected: %d, Actual: %d", expected, actual));
        }else {
            System.out.println("Test passed.");
        }
    }
}
