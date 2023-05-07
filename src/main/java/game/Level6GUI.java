// Level6GUI.java
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

public class Level6GUI {

    private Wizard wizard;
    private Level6 level6;

    public Level6GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level6 = new Level6(wizard); // Pass the wizard object when creating a new Level6 object
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        try {
            Image background = new Image(getClass().getResource("/level4.png").toExternalForm());
            BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(500, 500, false, false, false, true));
            root.setBackground(new Background(backgroundImage));
        } catch (NullPointerException e) {
            System.err.println("Background image not found.");
        }
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);

        Label welcomeLabel = new Label("Welcome to " + level6.getLocation() + "!");
        Label enemyLabel = new Label("You have entered the " + level6.getLocation() + ", but a Dark Wizard has appeared and is attacking you.");

        welcomeLabel.setEffect(dropShadow);
        welcomeLabel.setTextFill(Color.WHITE);
        enemyLabel.setEffect(dropShadow);
        enemyLabel.setTextFill(Color.WHITE);

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            primaryStage.close();
            Level level = new Level6(wizard); // Pass the wizard object when creating a new Level6 object
            BattleGUI battleGUI = new BattleGUI(level);
            Stage battleStage = new Stage();
            battleGUI.start(battleStage);
        });

        root.getChildren().addAll(welcomeLabel, enemyLabel, startBattleButton);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
