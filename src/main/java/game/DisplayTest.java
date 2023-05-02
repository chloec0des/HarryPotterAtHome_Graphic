package game;

import java.util.Scanner;

public class DisplayTest {

    public static void main(String[] args) {
        // Test printMessage
        Display display = new Display();
        String message = "Hello, world!";
        display.printMessage(message);

        // Test clearConsole
        System.out.println("This text will be cleared");
        Display.clearConsole();

        // Test printSeparator
        Display.printSeparator(10);

        // Test printHeading
        String title = "Test Heading";
        Display.printHeading(title);

        // Test anythingToContinue
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Continuing...");
    }
}
