package org.comp301.ProfPractice.View;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.comp301.ProfPractice.Controller.Controller;
import org.comp301.ProfPractice.Controller.ControllerImpl;
import org.comp301.ProfPractice.Model.Song;

public class SongView implements FXComponent{
    private Song song;
    private Controller controller;
    private int songIndex;


    public SongView(Song song, int songIndex, Controller controller){
        this.song = song;
        this.controller = controller;
        this.songIndex = songIndex;
    }

    @Override
    public Parent render() {
        Pane hbox = new HBox();
        hbox.getStyleClass().add("song-layout");

        Button delete = new Button("\u274C");
        delete.setOnAction((ActionEvent e) -> {
            controller.deleteSong(this.songIndex);
        });

        Button moveUp = new Button("\u25B2");
        moveUp.setOnAction((ActionEvent e)->{
            controller.moveSongUp(songIndex);
        });
        Button moveDown = new Button("\u25BC");
        moveDown.setOnAction((ActionEvent e)->{
            controller.moveSongDown(songIndex);
        });


        Label songLabel = new Label(this.song.toString());

        hbox.getChildren().add(delete);
        hbox.getChildren().add(moveUp);
        hbox.getChildren().add(moveDown);
        hbox.getChildren().add(songLabel);
        return hbox;
    }
}
