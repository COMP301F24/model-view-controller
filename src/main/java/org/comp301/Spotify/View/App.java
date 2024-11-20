package org.comp301.Spotify.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.comp301.Spotify.Controller.Controller;
import org.comp301.Spotify.Controller.ControllerImpl;
import org.comp301.Spotify.Model.Playlist;
import org.comp301.Spotify.Model.PlaylistImpl;
import org.comp301.Spotify.Model.Song;
import org.comp301.Spotify.Model.SongImpl;

public class App extends Application {
    @Override
    public void start(Stage stage){
        //Model
        Song icky = new SongImpl("Icky Thump", "White Stripes", 4);
        Playlist playlist = new PlaylistImpl();
        playlist.addSong(icky,0);

        //Controller
        Controller controller = new ControllerImpl(playlist);

        //View
        View view = new View(playlist, controller, stage);
        playlist.addPlaylistObserver(view);

        Scene scene = new Scene(view.render());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
