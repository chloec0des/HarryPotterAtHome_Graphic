// Level4GUI.java

package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level4GUI {

    private Wizard wizard;
    private Level4 level4;

    public Level4GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level4 = new Level4(wizard); // Pass the wizard object when creating a new Level4 object
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to " + wizard.getName() + " at " + level4.getLocation() + "!");
        Label enemyLabel = new Label("You are facing " + level4.getEnemy().getName() + " that have appeared!");

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            Level level = new Level4(wizard); // Pass the wizard object when creating a new Level4 object
            BattleGUI battleGUI = new BattleGUI(level);
            Stage battleStage = new Stage();
            battleGUI.start(battleStage);
        });

        root.getChildren().addAll(welcomeLabel, enemyLabel, startBattleButton);

        Scene scene = new Scene(root, 500, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
