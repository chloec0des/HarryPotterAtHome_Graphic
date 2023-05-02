package game;

import characters.Wizard;
import items.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Display display = new Display();
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            display.printMessage(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                display.printMessage("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    private Wizard wizard;
    public Wizard getWizard() {
        return wizard;
    }
    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
    public void init() {
        display.clearConsole();
        display.printSeparator(30);
        display.printHeading("Harry Potter at Home - by Chloé Toledano");
        wizard = initWizard();
        play(wizard);
    }

    public void play(Wizard wizard) {
        int currentLevel = 1;
        boolean isPlaying = true;

        while (isPlaying) {
            display.printMessage("Level " + currentLevel);
            // Call the appropriate level method based on the currentLevel.
            switch (currentLevel) {
                case 1 -> {
                    Level1 level1 = new Level1(wizard);
                    level1.playLevel(wizard);
                }
                case 2 -> {
                    Level2 level2 = new Level2(wizard);
                    level2.playLevel(wizard);
                }
                case 3 -> {
                    Level3 level3 = new Level3(wizard);
                    level3.playLevel(wizard);
                }
                case 4 -> {
                    Level4 level4 = new Level4(wizard);
                    level4.playLevel(wizard);
                }
                case 5 -> {
                    Level5 level5 = new Level5(wizard);
                    level5.playLevel(wizard);
                }
                case 6 -> {
                    Level6 level6 = new Level6(wizard);
                    level6.playLevel(wizard);
                }
                case 7 -> {
                    Level7 level7 = new Level7(wizard);
                    level7.playLevel(wizard);
                }
                default -> {
                    display.printMessage("Congratulations! You have completed all the levels!");
                    isPlaying = false;
                }
            }

            // Check if the wizard is still alive.
            if (wizard.getHealthPoints() <= 0) {
                display.printMessage("Game Over! Your wizard has died.");
                isPlaying = false;
            } else {
                currentLevel++;
            }
        }
    }
    Wizard initWizard() {
        // Initialize the wizard with default values
        display.printMessage("Enter your name: ");
        String name = scanner.nextLine();
        display.anythingToContinue();
        display.printMessage("Welcome young wizard, I am Hagrid! I will guide you through this adventure and hopefully keep you alive with my wisdom!");
        // Let the user know that their house, wand, and pet will be chosen for them
        display.printMessage("Initializing wizard... Your house, wand will now be chosen for you. You can chose your pet!");
        House house = SortingHat.randomHouse();
        display.printMessage("The Sorting Hat has placed you in " + house + " house!");
        display.anythingToContinue();

        Core[] cores = Core.values();
        int randomCoreIndex = new Random().nextInt(cores.length);
        Core randomCore = cores[randomCoreIndex];
        int randomSize = new Random().nextInt(15) + 5;
        Wand wand = new Wand(randomCore, randomSize);
        display.printMessage("You have received a " + randomSize + " inch wand with a " + randomCore.getName() + " core.");
        display.anythingToContinue();

        display.printMessage("Choose your pet:");
        Pet[] pets = Pet.values();
        for (int i = 0; i < pets.length; i++) {
            display.printMessage((i + 1) + ". " + pets[i]);
        }
        int petChoice = readInt("Enter the number corresponding to your desired pet (1-" + pets.length + "): ", pets.length);
        Pet chosenPet = pets[petChoice - 1];
        display.printMessage("You have chosen a " + chosenPet + " as your pet.");
        display.anythingToContinue();

        int healthPoints = 100;
        Wizard wizard = new Wizard(healthPoints, name, house, wand, chosenPet);
        display.printMessage("Welcome, " + wizard.getName() + "! Let's begin your adventure.");
        display.anythingToContinue();
        return wizard;
    }
    public static String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        display.printMessage(prompt);
        return scanner.nextLine();
    }


}