// Level5GUI.java

package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level5GUI {

    private Wizard wizard;
    private Level5 level5;

    public Level5GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level5 = new Level5(wizard);
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to " + wizard.getName() + " at " + level5.getLocation() + "!");
        Label enemyLabel = new Label("You are facing a powerful " + level5.getEnemy().getName() + " that has appeared!");

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            Level level = new Level5(wizard);
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
