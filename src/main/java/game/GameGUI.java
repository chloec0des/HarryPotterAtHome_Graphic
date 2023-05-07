package game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GameGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        try {
            Image background = new Image(getClass().getResource("/Harry.png").toExternalForm());
            BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(500, 500, false, false, false, true));
            root.setBackground(new Background(backgroundImage));
        } catch (NullPointerException e) {
            System.err.println("Background image not found.");
        }
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);

        Label welcomeLabel = new Label("Welcome to Harry Potter at Home");
        welcomeLabel.setEffect(dropShadow);
        welcomeLabel.setTextFill(Color.WHITE);
        Label nameLabel = new Label("Enter your wizard name:");
        nameLabel.setEffect(dropShadow);
        nameLabel.setTextFill(Color.WHITE);
        TextField nameField = new TextField();
        Button startButton = new Button("Start Game");
        startButton.setEffect(dropShadow);
        startButton.setTextFill(Color.GREEN);

        root.getChildren().addAll(welcomeLabel, nameLabel, nameField, startButton);
        Scene scene = new Scene(root, 800, 500);

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
