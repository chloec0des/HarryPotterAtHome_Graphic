package game;

import characters.Enemy;
import characters.Wizard;
import items.Potion;
import items.Spell;
import items.Sword;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;
import java.util.Random;

public class BattleGUI {
    private Button nextLevelButton;
    private Label missedSpellLabel;
    private Level level;
    private Wizard wizard;
    private Enemy enemy;
    private Spell spell;
    private Optional<Sword> sword;

    public BattleGUI(Level level) {
        this.level = level;
        this.wizard = level.getWizard();
        this.enemy = level.getEnemy();
        this.spell = level.getSpell();
        this.sword = level.getSword();
        nextLevelButton = new Button("Next Level");
        nextLevelButton.setVisible(false);
        missedSpellLabel=new Label("You missed the spell!");
        missedSpellLabel.setVisible(false);
    }

    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label wizardHealthLabel = new Label("Your health: " + wizard.getHealthPoints());
        Label enemyHealthLabel = new Label("Enemy health: " + enemy.getHealthPoints());

        Button attackSpellButton = new Button("Attack with " + spell.getName());
        attackSpellButton.setOnAction(event -> {
            attackEnemy(primaryStage);
            updateLabels(wizardHealthLabel, enemyHealthLabel);
        });


        Button usePotionButton = new Button("Use a healing potion");
        usePotionButton.setOnAction(event -> {
            // Wizard uses a healing potion
            Potion potion = Potion.choosePotion();
            potion.use(wizard);
            updateLabels(wizardHealthLabel, enemyHealthLabel);
            level.getDisplay().printMessage("You used a " + (potion.getHealAmount() == 30 ? "small" : "large") + " healing potion and regained " + potion.getHealAmount() + " HP. Your current HP is " + wizard.getHealthPoints() + ".");
        });

        Button attackSwordButton = new Button("Attack with " + (sword.isPresent() ? sword.get().getName() : "Sword"));
        // Show "use sword" button only for Gryffindor wizards in level 2
        attackSwordButton.setVisible(wizard.getHouse().equals("Gryffindor") && level.getLevelNumber() == 2);
        attackSwordButton.setOnAction(event -> {
            // Wizard attacks with sword
            if (sword.isPresent()) {
                Sword gryffindorSword = sword.get();
                enemy.takeDamage(gryffindorSword.getDamage());
            }
            updateLabels(wizardHealthLabel, enemyHealthLabel);
        });
        root.getChildren().addAll(enemyHealthLabel, wizardHealthLabel, attackSpellButton, usePotionButton, attackSwordButton, missedSpellLabel);

        Scene scene = new Scene(root, 500, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
        nextLevelButton.setOnAction(event -> {
            primaryStage.close();
            int currentLevelNumber = level.getLevelNumber();
            Stage nextLevelStage = new Stage();

            switch (currentLevelNumber) {
                case 1:
                    new Level2GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 2:
                    new Level3GUI(level.getWizard()).start(nextLevelStage);
                    break;
                // Add more cases for other levels here
            }
            primaryStage.close();
        });
    }

    private void updateLabels(Label wizardHealthLabel, Label enemyHealthLabel) {
        wizardHealthLabel.setText("Your health: " + wizard.getHealthPoints());
        enemyHealthLabel.setText("Enemy health: " + enemy.getHealthPoints());
    }

    public void attackEnemy(Stage primaryStage) {
        Wizard wizard = level.getWizard();
        Enemy enemy = level.getEnemy();
        Spell spell = level.getSpell();

        Random random = new Random();
        int chance = random.nextInt(100) + 1;

        if (chance <= spell.getAccuracy()) {
            // Successful attack
            enemy.takeDamage((int) spell.getDamage());
            level.getDisplay().printMessage("You dealt " + spell.getDamage() + " damage to " + enemy.getName() + "!");

            if (enemy.getHealthPoints() <= 0) {
                // Enemy is defeated
                enemyDefeated(primaryStage);
            } else {
                // Enemy attacks the wizard
                wizard.takeDamage(enemy.getDamage());
                level.getDisplay().printMessage("The " + enemy.getName() + " dealt " + enemy.getDamage() + " damage to you.");

                // Check if the wizard is dead
                if (wizard.getHealthPoints() <= 0) {
                    primaryStage.close();
                    new GameOverGUI().start(new Stage());
                }
            }
        } else {
            missedSpellLabel.setVisible(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> missedSpellLabel.setVisible(false));
            pause.play();
        }
        }



    public void enemyDefeated(Stage primaryStage) {
        Label victoryLabel = new Label("You won this battle! Let's go to the next level!");
        Button nextLevelButton = new Button("Next Level");

        nextLevelButton.setOnAction(event -> {
            primaryStage.close();
            int currentLevelNumber = level.getLevelNumber();
            Stage nextLevelStage = new Stage();

            switch (currentLevelNumber) {
                case 1:
                    new Level2GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 2:
                    new Level3GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 3:
                    new Level4GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 4:
                    new Level5GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 5:
                    new Level6GUI(level.getWizard()).start(nextLevelStage);
                    break;
                case 6:
                    new Level7GUI(level.getWizard()).start(nextLevelStage);
                    break;

            }
        });

        VBox root = (VBox) primaryStage.getScene().getRoot();
        root.getChildren().addAll(victoryLabel, nextLevelButton);
    }
}