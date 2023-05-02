package game;

import characters.Enemy;
import characters.Wizard;
import items.*;

import java.util.Optional;

public class LevelTest {
    public static void main(String[] args) {
        // Create a wizard, an enemy, a spell, and a sword
        Wizard wizard = new Wizard(100, "Harry Potter", House.GRYFFINDOR, new Wand(Core.PHOENIX_FEATHER, 5), Pet.CAT);
        Enemy enemy = new Enemy("Dementor", 50, 10);
        Spell spell = new Spell("Expecto Patronum", 30, 90);
        Sword sword = new Sword("Gryffindor Sword", 40);

        // Test the battle method
        Level.battle(wizard, enemy, spell, Optional.of(sword));
    }
}
