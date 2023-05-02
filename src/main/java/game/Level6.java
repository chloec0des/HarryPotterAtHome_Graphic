package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;

public class Level6 extends Level {
    private Wizard wizard;
    public Level6(Wizard wizard) {
        super("Level 6", "Astronomy Tower", new Enemy("Dark Wizard", 60, 150));
        this.wizard=wizard;
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + getLocation() + "!");
        display.printMessage("You have entered the " + getLocation() + ", but a Dark Wizard has appeared and is attacking you.");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Sectumsempra", 30, 50);
        if (wizard.getHouse().getName().equals("Slytherin")) {
            display.printMessage("As a member of Slytherin, you have the option to ally with the Death Eaters. ");
            String allyChoice = Game.readString("Will you ally with them? (y/n)");

            if (allyChoice.equalsIgnoreCase("y")) {
                super.setEnemy(new Enemy("Death Eater", 70, 200));
                display.printMessage("You have allied with the Death Eaters.");
            } else {
                display.printMessage("You have chosen not to ally with the Death Eaters.");
                Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            }
        }
        Level.battle(wizard, super.getEnemy(), spell, Optional.empty());

        if (wizard.getHealthPoints() <= 0) {
            display.printMessage("You have been defeated. Game over!");
            return;
        }

        Level.choiceIncrease(wizard, spell);

        if (getEnemy().getHealthPoints() <= 0) {
            Level.endingLevel(wizard, getEnemy(), 6);
            display.anythingToContinue();
            // Add reward to inventory
            Reward reward = new Reward("an invisibility cloak");
            wizard.getInventory().addItem(reward);
            display.printMessage("You have received " + reward.getReward() + " as a reward.");
            Inventory inventory = wizard.getInventory();
            inventory.printInventory();
            display.anythingToContinue();
        }
    }
    @Override
    public Wizard getWizard() {
        return wizard;
    }

    @Override
    public Spell getSpell() {
        return new Spell("Sectumsempra", 30, 50);
    }

    @Override
    public Optional<Sword> getSword() {
        return Optional.empty();
    }
    @Override
    public int getLevelNumber(){
        return 6;
    }
}