package org.comp301.Spotify.Model;



public interface Playlist extends Iterable<Song> {

    int getNumSongs();
    Song getSong(int index);
    void removeSong(int index);
    void addSong(Song song, int index);
    void shuffle();
    void addPlaylistObserver(PlaylistObserver observer);
    void removePlaylistObserver(PlaylistObserver observer);
}
