module HarryPotterAtHome_graphic {
    requires javafx.controls;
    requires javafx.fxml;

    exports game;
    opens game to javafx.fxml;

}