package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level2GUI {

    private Wizard wizard;
    private Level2 level2;

    public Level2GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level2 = new Level2(wizard); // Pass the wizard object when creating a new Level2 object
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to " + wizard.getName() + " at " + level2.getLocation() + "!");
        Label enemyLabel = new Label("You are facing a wild " + level2.getEnemy().getName() + " that has appeared!");

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            Level level = new Level2(wizard); // Pass the wizard object when creating a new Level2 object
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
