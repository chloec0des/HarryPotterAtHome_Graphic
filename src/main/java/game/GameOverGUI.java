package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOverGUI {

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label gameOverLabel = new Label("Game Over");

        Button restartButton = new Button("Restart Game");
        restartButton.setOnAction(event -> {
            primaryStage.close();
            new GameGUI().start(new Stage());
        });

        Button quitGameButton = new Button("Quit Game");
        quitGameButton.setOnAction(event -> {
            primaryStage.close();
        });

        root.getChildren().addAll(gameOverLabel, restartButton, quitGameButton);

        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
