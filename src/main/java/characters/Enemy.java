package characters;

public class Enemy extends Character {
    public Enemy(String username, int damage, int healthPoints) {
        super(username, damage, healthPoints);
        setDamage(damage);
    }
    public String getUsername() {
        return this.getName();
    }

    public void takeDamage(double damage) {
        setHealthPoints((int)(getHealthPoints() - damage));
        if (getHealthPoints() < 0) {
            setHealthPoints(0);
        }

    }
}