package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;

public class Level2 extends Level {
    private Wizard wizard;

    public Level2(Wizard wizard) {

        super("Level 2", "Chamber of Secrets", new Enemy("Basilisk", 20, 70));
        this.wizard= wizard;
    }

    @Override
    public Wizard getWizard() {
        return wizard;
    }

    @Override
    public Spell getSpell() {
        return new Spell("Accio", 25, 40);
    }

    @Override
    public Optional<Sword> getSword() {
        if (wizard.getHouse() == House.GRYFFINDOR) {
            Sword sword = wizard.getInventory().getItemByType(Sword.class);
            return Optional.ofNullable(sword);
        }
        return Optional.empty();
    }

    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome back for this new year " + getName() + " in the " + getLocation() + "!");
        display.printMessage("You are facing a wild " + getEnemy().getName() + " that has appeared!");

        // Perform level-specific gameplay mechanics here
        Spell spell = new Spell("Accio", 25, 40);
        Optional<Sword> swordOptional = Optional.empty();
        if (wizard.getHouse() == House.GRYFFINDOR) {
            Sword sword = wizard.getInventory().getItemByType(Sword.class);
            swordOptional = Optional.ofNullable(sword);
        }
        Level.battle(wizard, getEnemy(), spell, swordOptional);
        if (wizard.getHealthPoints() > 0) {
            Level.choiceIncrease(wizard, spell);
            if (getEnemy().getHealthPoints() <= 0) {
                display.printMessage("You have successfully defeated the Basilisk!");
                learnPatronus(wizard);
                Level.endingLevel(wizard, getEnemy(), 2);
                display.anythingToContinue();
                Reward reward = new Reward(" a choco frog");
                wizard.getInventory().addItem(reward);
                display.printMessage("You have received " + reward.getReward() + " as a reward.");
                Inventory inventory = wizard.getInventory();
                inventory.printInventory();
                display.anythingToContinue();
            }
        }
        swordOptional.ifPresent(s -> wizard.getInventory().removeItem(s));
    }
    private void learnPatronus(Wizard wizard) {
        display.printMessage("Congratulations on defeating the Basilisk! You have unlocked the ability to cast a Patronus.");
        Patronus patronus = new Patronus(Game.readString("Enter to learn your Patronum and finish this second year! Remember, this spell will be useful later... Sooner than you imagine"), 50);
        wizard.getInventory().addItem(patronus);
        display.printMessage("You have learned to cast Expecto Patronum, and your Patronus has been added to your inventory.");
    }
    @Override
    public int getLevelNumber(){
        return 2;
    }
}
