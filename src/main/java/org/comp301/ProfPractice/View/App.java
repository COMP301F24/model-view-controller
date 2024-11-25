package org.comp301.ProfPractice.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.comp301.ProfPractice.Controller.Controller;
import org.comp301.ProfPractice.Controller.ControllerImpl;
import org.comp301.ProfPractice.Model.Playlist;
import org.comp301.ProfPractice.Model.PlaylistImpl;
import org.comp301.ProfPractice.Model.Song;
import org.comp301.ProfPractice.Model.SongImpl;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Model
        Playlist playlist = new PlaylistImpl();
        Song icky = new SongImpl("Icky Thump", "White Stripes", 4);
        Song combat = new SongImpl("Combat", "Flobots", 5);
        Song heyYa = new SongImpl("Hey Ya", "Outkast", 5);
        Song moonage = new SongImpl("Moonage Daydream", "David Bowie", 5);
        Song hammerTime = new SongImpl("Cant Touch This", "MC Hammer", 3);

        playlist.addSong(icky);
        playlist.addSong(combat);
        playlist.addSong(heyYa);
        playlist.addSong(moonage);
        playlist.addSong(hammerTime);

        //Controller
        Controller controller = new ControllerImpl(playlist);

        //View
        View view = new View(controller, playlist, stage);
        playlist.addObserver(view);

        Scene scene = new Scene(view.render());
        scene.getStylesheets().add("style/playlist-style.css");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
