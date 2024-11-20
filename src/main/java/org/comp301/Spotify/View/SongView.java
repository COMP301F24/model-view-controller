package org.comp301.Spotify.View;

import org.comp301.Spotify.Model.Song;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SongView implements FXComponent {

    private Song song;

    public SongView(Song song) {
        this.song = song;
    }

    public Parent render() {
        Pane hbox = new HBox();
        Button deleteButton = new Button("\u274C");
        Button upButton = new Button("\u25B2");
        Button downButton = new Button("\u25BC");
        Label songLabel = new Label(makeSongLabel());

        hbox.getChildren().add(deleteButton);
        hbox.getChildren().add(upButton);
        hbox.getChildren().add(downButton);
        hbox.getChildren().add(songLabel);

        return hbox;
    }

    private String makeSongLabel() {
        String label = "";
        label += song.getTitle() + " by "
                + song.getArtist() + " (";
        for (int i=0; i<song.getRating(); i++) {
            label += "\u2605";
        }
        for (int i=song.getRating(); i<5; i++) {
            label += "\u2606";
        }
        label += ")";
        return label;
    }
}
