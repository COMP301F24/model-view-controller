package org.comp301.Spotify.View;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ControlPanel implements FXComponent {
    public Parent render() {
        StackPane ctrl_panel = new StackPane();
        Button shuffle = new Button("Shuffle");

        ctrl_panel.getChildren().add(shuffle);
        return ctrl_panel;
    }
}
