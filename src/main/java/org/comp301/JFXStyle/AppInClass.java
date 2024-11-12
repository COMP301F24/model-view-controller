package org.comp301.JFXStyle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppInClass extends Application {
    @Override
    public void start(Stage stage) {
        // Set the Stage title
        stage.setTitle("Play 2048!");

        // Create new Pane objects to hold the UI components
        Pane layout = new VBox();

        // Set the Scene
        Scene scene = new Scene(layout, 350, 450);

        stage.setScene(scene);

        // Show the Stage on the screen
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static Label makeTile(int num) {
        Label tile;
        if (num == 0) {
            tile = new Label();
        } else {
            tile = new Label(String.valueOf(num));
        }
        tile.getStyleClass().add("tile");
        tile.getStyleClass().add("tile-" + num);
        return tile;
    }
}