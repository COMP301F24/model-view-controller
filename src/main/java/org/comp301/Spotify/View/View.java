package org.comp301.Spotify.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.comp301.Spotify.Controller.Controller;
import org.comp301.Spotify.Model.Playlist;
import org.comp301.Spotify.Model.PlaylistObserver;

public class View implements FXComponent, PlaylistObserver {
    Playlist model;
    Controller controller;
    Stage stage;

    View(Playlist model, Controller controller, Stage stage){
        this.model = model;
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public Parent render() {
        Pane vbox = new VBox();
        ControlPanel controlPanel = new ControlPanel();
        PlaylistPanel playlistPanel = new PlaylistPanel(model);
        AddSongPanel addSongPanel = new AddSongPanel();


        vbox.getChildren().add(controlPanel.render());
        vbox.getChildren().add(playlistPanel.render());
        vbox.getChildren().add(addSongPanel.render());

        return vbox;
    }

    @Override
    public void update(Playlist playlist) {
        Scene scene = new Scene(render());
        stage.setScene(scene);
    }
}
