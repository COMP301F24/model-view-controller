package org.comp301.ProfPractice.View;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.comp301.ProfPractice.Controller.Controller;
import org.comp301.ProfPractice.Model.Playlist;
import org.comp301.ProfPractice.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistPanel implements FXComponent {
  Playlist playlist;
  Controller controller;

  public PlaylistPanel(Playlist playlist, Controller controller) {
    this.playlist = playlist;
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Pane vbox = new VBox();
    for (int i=0; i< playlist.getNumSongs(); i++) {
      SongView sv = new SongView(playlist.getSong(i), i, controller);
      vbox.getChildren().add(sv.render());
    }
    return vbox;
  }
}
