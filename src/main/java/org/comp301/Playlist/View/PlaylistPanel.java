package org.comp301.Playlist.View;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.comp301.Playlist.Controller.Controller;
import org.comp301.Playlist.Model.Playlist;

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
