package game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GameGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to Harry Potter at Home");
        Label nameLabel = new Label("Enter your wizard name:");
        TextField nameField = new TextField();
        Button startButton = new Button("Start Game");

        root.getChildren().addAll(welcomeLabel, nameLabel, nameField, startButton);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
        startButton.setOnAction(event -> {
            String wizardName = nameField.getText();
            Stage wizardInitStage = new Stage();
            WizardInitGUI wizardInitGUI = new WizardInitGUI();
            wizardInitGUI.start(wizardInitStage, wizardName);
            primaryStage.close(); // close the start game window
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}
