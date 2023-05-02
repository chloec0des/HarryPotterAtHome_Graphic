package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;
import java.util.Random;

public class Level7 extends Level {
    private Wizard wizard;

    public Level7(Wizard wizard) {
        super("Level 7", "Hogwarts", new Enemy("Voldemort", 80, 250));
        this.wizard=wizard;
    }
    public void playLevel(Wizard wizard) {
        display.printMessage("Welcome back to " + getLocation() + "!");
        display.printMessage("You have finally reached your last year, where Voldemort awaits you.");

        // Perform level-specific gameplay mechanics here
        Wand voldemortWand = generateVoldemortWand();
        if (voldemortWand.getCore() == wizard.getWand().getCore()) {
            finalBattle(wizard, super.getEnemy());
        } else {
            Spell spell = new Spell("Expelliarmus", 80, 50);
            Level.battle(wizard, super.getEnemy(), spell, Optional.empty());
            if (wizard.getHealthPoints() > 0) {
                Level.choiceIncrease(wizard, spell);
                Potion chosenPotion = Potion.choosePotion();
                chosenPotion.use(wizard);
                if (getEnemy().getHealthPoints() <= 0) {
                    Level.endingLevel(wizard, getEnemy(), 7);
                }
            }
        }
    }

    private Wand generateVoldemortWand() {
        Core voldemortCore = Core.PHOENIX_FEATHER;
        Random random = new Random();
        return new Wand(voldemortCore, random.nextInt(25) + 1);
    }


    private void finalBattle(Wizard wizard, Enemy enemy) {
        Core wizardCore = wizard.getWand().getCore();
        Core voldemortCore = generateVoldemortWand().getCore();
        if (wizardCore == voldemortCore) {
            display.printMessage("Your chance of winning against Voldemort is now 50% because you have the same core.");
            Random random = new Random();
            boolean wizardWins = random.nextBoolean();
            Display.anythingToContinue();
            if (wizardWins) {
                display.printMessage("You have defeated Voldemort! Congratulations!");
                Level.endingLevel(wizard, enemy, 7);
            } else {
                display.printMessage("Unfortunately, Voldemort has defeated you. Game over!");
            }
        } else {
            display.printMessage("You face Voldemort in the final battle!");
            Spell spell = new Spell("Expelliarmus", 80, 50);
            Level.battle(wizard, enemy, spell, Optional.empty());
            if (wizard.getHealthPoints() > 0) {
                Level.choiceIncrease(wizard, spell);
                Potion chosenPotion = Potion.choosePotion();
                chosenPotion.use(wizard);
                if (enemy.getHealthPoints() <= 0) {
                    display.printMessage("You have defeated Voldemort! Congratulations!");
                    Level.endingLevel(wizard, enemy, 7);
                    display.printMessage("You won the entire game and received some gifts along the way for you to collect! It was a pleasure to have you!");
                    display.anythingToContinue();
                    // Add reward to inventory
                    Reward reward = new Reward("an invisibility cloak");
                    wizard.getInventory().addItem(reward);
                    display.printMessage("You have received " + reward.getReward() + " as a reward.");
                    Inventory inventory = wizard.getInventory();
                    inventory.printInventory();

                }
            } else {
                display.printMessage("Unfortunately, Voldemort has defeated you. Game over!");
            }
        }
    }
    @Override
    public Wizard getWizard() {
        return wizard;
    }

    @Override
    public Spell getSpell() {
        return new Spell("Expelliarmus", 80, 50);
    }

    @Override
    public Optional<Sword> getSword() {
        return Optional.empty();
    }
    @Override
    public int getLevelNumber(){
        return 7;
    }
}