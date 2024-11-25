package org.comp301.ProfPractice.Controller;

import org.comp301.ProfPractice.Model.Playlist;
import org.comp301.ProfPractice.Model.SongImpl;

public class ControllerImpl implements Controller{
    private Playlist playlist;

    public ControllerImpl(Playlist playlist){
        this.playlist = playlist;
    }

    @Override
    public void shuffle() {
        playlist.shuffleSongs();
    }

    @Override
    public void deleteSong(int song_index) {
        playlist.removeSong(song_index);

    }

    @Override
    public void addSong(String title, String artist, int rating) {
        playlist.addSong(new SongImpl(title,artist,rating));
    }

    @Override
    public void moveSongUp(int song_index) {
        if (song_index > 0) {
            playlist.moveSong(song_index, song_index - 1);
        }
    }

    @Override
    public void moveSongDown(int song_index) {
        if (song_index < playlist.getNumSongs()-1) {
            playlist.moveSong(song_index, song_index + 1);
        }
    }
}
