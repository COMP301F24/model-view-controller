package org.comp301.Spotify.View;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.comp301.Spotify.Model.Playlist;
import org.comp301.Spotify.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistPanel implements FXComponent{

  private List<SongView> songviews = new ArrayList<>();

    public PlaylistPanel(Playlist playlist) {
            for(Song s : playlist){
                SongView songView = new SongView(s);
                songviews.add(songView);
            }
    }
    @Override
    public Parent render() {
        Pane vbox = new VBox();
        for (SongView sv : songviews) {
            vbox.getChildren().add(sv.render());
        }
        return vbox;
    }
}