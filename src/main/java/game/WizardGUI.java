package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class WizardGUI {

    private Wizard wizard;

    public WizardGUI(Wizard wizard) {
        this.wizard = wizard;
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Name: " + wizard.getName());
        Label houseLabel = new Label("House: " + wizard.getHouse());
        Label wandLabel = new Label("Wand: " + wizard.getWand().getSize() + " inch, " + wizard.getWand().getCore().getName() + " core");
        Label petLabel = new Label("Pet: " + wizard.getPet());
        Button startPlayingButton = new Button("Start Playing");
        startPlayingButton.setOnAction(event -> {
            primaryStage.hide(); // Hide the current window

            // Create a new instance of Level1GUI and show it
            Level1GUI level1GUI = new Level1GUI(wizard);
            level1GUI.start(new Stage());
        });

        root.getChildren().addAll(nameLabel, houseLabel, wandLabel, petLabel, startPlayingButton);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
