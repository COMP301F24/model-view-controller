package org.comp301.ProfPractice.View;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View implements FXComponent{


    @Override
    public Parent render() {
        Pane pane = new VBox();
        ControlPanel c = new ControlPanel();
        pane.getChildren().add(c.render());
        return pane;
    }
}
