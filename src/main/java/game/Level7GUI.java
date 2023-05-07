package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Level7GUI {

    private Wizard wizard;
    private Level7 level7;

    public Level7GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level7 = new Level7(wizard); // Pass the wizard object when creating a new Level7 object
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        try {
            Image background = new Image(getClass().getResource("/level7.png").toExternalForm());
            BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(500, 500, false, false, false, true));
            root.setBackground(new Background(backgroundImage));
        } catch (NullPointerException e) {
            System.err.println("Background image not found.");
        }
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);

        Label welcomeLabel = new Label("Welcome to " + level7.getLocation() + "!");
        Label enemyLabel = new Label("You have finally reached your last year, where Voldemort awaits you.");

        welcomeLabel.setEffect(dropShadow);
        welcomeLabel.setTextFill(Color.WHITE);
        enemyLabel.setEffect(dropShadow);
        enemyLabel.setTextFill(Color.WHITE);

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            primaryStage.close();
            Level level = new Level7(wizard); // Pass the wizard object when creating a new Level7 object
            BattleGUI battleGUI = new BattleGUI(level);
            Stage battleStage = new Stage();
            battleGUI.start(battleStage);
        });

        root.getChildren().addAll(welcomeLabel, enemyLabel, startBattleButton);

        Scene scene = new Scene(root, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
