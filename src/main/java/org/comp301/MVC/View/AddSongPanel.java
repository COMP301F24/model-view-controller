package org.comp301.MVC.View;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.comp301.Playlist.Controller.Controller;

public class AddSongPanel implements FXComponent {
    private Controller controller;

    public AddSongPanel(Controller controller){
        this.controller = controller;
    }
    @Override
    public Parent render() {
        Pane hbox = new HBox();
        hbox.getStyleClass().add("add-song-layout");


        // Title
        TextField titleInput = new TextField();
        hbox.getChildren().add(new Label("Song:"));
        hbox.getChildren().add(titleInput);

        // Artist
        TextField artistInput = new TextField();
        hbox.getChildren().add(new Label("Artist:"));
        hbox.getChildren().add(artistInput);

        // Rating
        Slider ratingSlider = new Slider(0, 5, 5);
        ratingSlider.getStyleClass().add("add-song-slider");
        hbox.getChildren().add(new Label("Rating:"));
        hbox.getChildren().add(ratingSlider);

        // Add button
        Button addButton = new Button("\uff0b");
        addButton.setOnAction((ActionEvent e) -> {
            String title = titleInput.getText();
            String artist = artistInput.getText();
            int rating = (int) ratingSlider.getValue();

            controller.addSong(title, artist, rating);
        });

        hbox.getChildren().add(addButton);

        return hbox;
    }
}
