package org.comp301.MVC.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.comp301.Playlist.Controller.Controller;
import org.comp301.Playlist.Model.Playlist;
import org.comp301.Playlist.Model.PlaylistObserver;

public class View implements FXComponent, PlaylistObserver {
    Playlist model;
    Controller controller;
    Stage stage;

    public View(Controller controller, Playlist model, Stage stage){
        this.controller = controller;
        this.model = model;
        this.stage = stage;
    }

    @Override
    public void update(Playlist model) {
        Scene scene = new Scene(render());
        scene.getStylesheets().add("style/playlist-style.css");
        stage.setScene(scene);
    }

    @Override
    public Parent render() {
        Pane pane = new VBox();
        ControlPanel c = new ControlPanel(controller);
        pane.getChildren().add(c.render());

        PlaylistPanel p = new PlaylistPanel(model, controller);
        pane.getChildren().add((p.render()));

        AddSongPanel a = new AddSongPanel(controller);
        pane.getChildren().add(a.render());

        return pane;
    }

}
