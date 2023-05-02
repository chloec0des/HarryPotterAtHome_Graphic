package characters;

public abstract class AbstractEnemy extends Character {
    private int experiencePoints;

    public AbstractEnemy(String name, int damage, int healthPoints, int experiencePoints) {
        super(name, damage, healthPoints);
        this.experiencePoints = experiencePoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public abstract void attack(java.lang.Character character);
}
