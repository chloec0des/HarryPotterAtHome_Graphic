package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;

public class Level3 extends Level {
    private Wizard wizard;
    public Level3(Wizard wizard) {

        super("Level 3", "Forbidden Forest", new Enemy("Dementor", 30, 100));
        this.wizard= wizard;
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome to " + getLocation() + "!");
        display.printMessage("You have entered the " + getLocation() + ", but a Dementor is lurking in the shadows.");

        // Level-specific mechanics here
        Spell spell = new Spell("Expecto Patronum", 40, 70);
        if (wizard.getInventory().getItemByType(Patronus.class) == null) {
            display.printMessage("You don't have a Patronus yet. Go back to Level 2 to learn how to cast one.");
            Level2 level2 = new Level2(wizard);
            level2.playLevel(wizard);
        } else {
            display.printMessage("You cast Expecto Patronum, and a " + wizard.getInventory().getItemByType(Patronus.class).getName() + " Patronus appears!");
            if (wizard.getHouse().getName().equals("Gryffindor")) {
                display.printMessage("As a member of Gryffindor, your Patronus is particularly effective against Dementors.");
                spell.setAccuracy(spell.getAccuracy() * 1.2);
                spell.setDamage(spell.getDamage() * 1.2);
            }
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() <= 0) {
                display.printMessage("You have been defeated. Game over!");
                return;
            }
            Level.choiceIncrease(wizard, spell);
            display.printMessage("You successfully cast Expecto Patronum and drove the Dementor away from the Forbidden Forest!");
            Level.endingLevel(wizard, getEnemy(), 3);
            display.anythingToContinue();
            Reward reward = new Reward("a Broomstick, the Nimbus 2000");
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
        return new Spell("Expecto Patronum", 40, 70);
    }

    @Override
    public Optional<Sword> getSword() {
        return Optional.empty();
    }
    @Override
    public int getLevelNumber(){
        return 3;
    }
}
