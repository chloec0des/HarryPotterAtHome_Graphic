package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;

public class Level5 extends Level {
private Wizard wizard;
    public Level5(Wizard wizard) {
        super("Level 5", "The Hogwarts Examination Room", new Enemy("Dolores Umbridge", 40, 150));
        this.wizard= wizard;
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + getName() + " at " + getLocation() + "!");
        display.printMessage("You are facing a powerful " + getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Stupefy", 50, 70);
        while (getEnemy().getHealthPoints() > 0) {
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                display.printMessage("You have been defeated. Game over!");
                return;
            }
        }

        Level.choiceIncrease(wizard, spell);

        display.printMessage("You defeated " + getEnemy().getName() + " and found some fireworks! Let's party! 🎉");

        Level.endingLevel(wizard, getEnemy(), 5);
        display.anythingToContinue();
        // Add fireworks to inventory
        Reward reward = new Reward("some Fireworks");
        wizard.getInventory().addItem(reward);
        display.printMessage("You have received " + reward.getReward() + " as a reward.");
        // Add fireworks to inventory
        Inventory inventory = wizard.getInventory();
        inventory.printInventory();
        display.anythingToContinue();
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }

    @Override
    public Spell getSpell() {
        return new Spell("Stupefy", 50, 70);
    }

    @Override
    public Optional<Sword> getSword() {
        return Optional.empty();
    }
    @Override
    public int getLevelNumber(){
        return 5;
    }
}
