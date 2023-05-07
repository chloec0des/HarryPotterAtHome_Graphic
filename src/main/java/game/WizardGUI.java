package game;

import characters.Wizard;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


public class WizardGUI {

    private Wizard wizard;

    public WizardGUI(Wizard wizard) {
        this.wizard = wizard;
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        Label sortingHatLabel = new Label("The Sorting Hat is choosing your house...\nHmm, interesting. Very interesting.\nI think I know just the place for you!");

        Label nameLabel = new Label("Name: " + wizard.getName());
        Label houseLabel = new Label("House: " + wizard.getHouse());
        Label wandLabel = new Label("Wand: " + wizard.getWand().getSize() + " inch, " + wizard.getWand().getCore().getName() + " core");
        Label petLabel = new Label("Pet: " + wizard.getPet());

        // Hide the wizard's information at the beginning
        nameLabel.setVisible(false);
        houseLabel.setVisible(false);
        wandLabel.setVisible(false);
        petLabel.setVisible(false);

        Button startPlayingButton = new Button("Start Playing");
        startPlayingButton.setVisible(false);
        startPlayingButton.setOnAction(event -> {
            primaryStage.hide(); // Hide the current window

            // Create a new instance of Level1GUI and show it
            Level1GUI level1GUI = new Level1GUI(wizard);
            level1GUI.start(new Stage());
        });

        root.getChildren().addAll(sortingHatLabel, nameLabel, houseLabel, wandLabel, petLabel, startPlayingButton);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        // Show the wizard's information after 5 seconds
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            sortingHatLabel.setVisible(false);
            nameLabel.setVisible(true);
            houseLabel.setVisible(true);
            wandLabel.setVisible(true);
            petLabel.setVisible(true);
            startPlayingButton.setVisible(true);
        });
        pause.play();
    }
}
