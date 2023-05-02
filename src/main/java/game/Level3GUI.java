// Level3GUI.java

package game;

import characters.Wizard;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level3GUI {

    private Wizard wizard;
    private Level3 level3;

    public Level3GUI(Wizard wizard) {
        this.wizard = wizard;
        this.level3 = new Level3(wizard); // Pass the wizard object when creating a new Level3 object
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome to " + level3.getLocation() + "!");
        Label enemyLabel = new Label("You have entered the " + level3.getLocation() + ", but a Dementor is lurking in the shadows.");

        Button startBattleButton = new Button("Start Battle");
        startBattleButton.setOnAction(event -> {
            Level level = new Level3(wizard); // Pass the wizard object when creating a new Level3 object
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
