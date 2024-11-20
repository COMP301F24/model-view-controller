package org.comp301.Spotify.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlaylistImpl implements Playlist {

    private List<Song> songs;
    private List<PlaylistObserver> observers;

    public PlaylistImpl() {
        songs = new ArrayList<Song>();
        observers = new ArrayList<PlaylistObserver>();
    }

    @Override
    public Iterator<Song> iterator(){
        return songs.iterator();
    }

    @Override
    public int getNumSongs() {
        return songs.size();
    }

    @Override
    public Song getSong(int index) {
        return songs.get(index);
    }

    @Override
    public void removeSong(int index) {
        songs.remove(index);

        notifyObservers();
    }

    @Override
    public void addSong(Song song, int index) {
        songs.add(index, song);

        notifyObservers();
    }

    public void shuffle() {
        Collections.shuffle(songs);
        notifyObservers();
    }

    @Override
    public void addPlaylistObserver(PlaylistObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removePlaylistObserver(PlaylistObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (PlaylistObserver o : observers) {
            o.update(this);
        }
    }
}
