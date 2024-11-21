package org.comp301.ProfPractice.View;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class ControlPanel implements FXComponent{
    @Override
    public Parent render() {
        Pane pane = new StackPane();
        Button button = new Button("Shuffle");
        pane.getChildren().add(button);

        return pane;
    }
}
