package org.comp301.Playlist.View;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.comp301.Playlist.Controller.Controller;


public class ControlPanel implements FXComponent{
    Controller controller;

    public ControlPanel(Controller controller){
        this.controller = controller;
    }


    @Override
    public Parent render() {
        Pane pane = new StackPane();
        pane.getStyleClass().add("controls-layout");

        Button button = new Button("Shuffle");
        button.setOnAction((ActionEvent e) ->{
            controller.shuffle();
        });
        pane.getChildren().add(button);

        return pane;
    }
}
