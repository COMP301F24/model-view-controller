package org.comp301.ProfPractice.Model;


public interface Playlist extends Iterable<Song> {
    Song getSong(int index);
    void addSong(Song song);
    void removeSong(int index);
    void moveSong(int oldIndex, int newIndex);
    void shuffleSongs();

    int getNumSongs();

    void addObserver(PlaylistObserver observer);
    void removeObserver(PlaylistObserver observer);
}
