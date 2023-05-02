package game;

import characters.Wizard;
import items.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class WizardInitGUI {

    public void start(Stage primaryStage, String wizardName) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label initLabel = new Label("Initializing wizard...");
        Label petLabel = new Label("Choose your pet:");
        ComboBox<Pet> petComboBox = new ComboBox<>();
        petComboBox.getItems().addAll(Pet.values());
        Button initButton = new Button("Initialize Wizard");

        root.getChildren().addAll(initLabel, petLabel, petComboBox, initButton);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
        initButton.setOnAction(event -> {
            Pet chosenPet = petComboBox.getValue();
            if (chosenPet != null) {
                Wizard wizard = initWizard(wizardName, chosenPet);
                Stage wizardStage = new Stage();
                WizardGUI wizardGUI = new WizardGUI(wizard);
                wizardGUI.start(wizardStage);
                primaryStage.close(); // close the wizard initialization window
            } else {
                // Show an error message if the user hasn't selected a pet
                Label errorLabel = new Label("Please choose a pet!");
                root.getChildren().add(errorLabel);
            }
        });
    }

    private Wizard initWizard(String name, Pet chosenPet) {
        House house = SortingHat.randomHouse();
        Core[] cores = Core.values();
        int randomCoreIndex = new Random().nextInt(cores.length);
        Core randomCore = cores[randomCoreIndex];
        int randomSize = new Random().nextInt(15) + 5;
        Wand wand = new Wand(randomCore, randomSize);
        int healthPoints = 100;

        Wizard wizard = new Wizard(healthPoints, name, house, wand, chosenPet);
        return wizard;
    }
}
