// Level7GUI.java

package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

        Label welcomeLabel = new Label("Welcome to " + level7.getLocation() + "!");
        Label enemyLabel = new Label("You have finally reached your last year, where Voldemort awaits you.");

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            Level level = new Level7(wizard); // Pass the wizard object when creating a new Level7 object
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
