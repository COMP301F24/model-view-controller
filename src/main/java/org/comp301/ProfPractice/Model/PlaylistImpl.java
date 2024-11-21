package org.comp301.ProfPractice.Model;

import java.util.*;

public class PlaylistImpl implements Playlist {
    List<Song> songs = new ArrayList<>();
    List<PlaylistObserver> observers = new ArrayList<>();

    public PlaylistImpl(){
    }

    public PlaylistImpl(List<Song> songs){
        this.songs = songs;
    }


    @Override
    public Song getSong(int index) {
        return this.songs.get(index);
    }

    @Override
    public void addSong(Song song) {
        this.songs.add(song);
        notifyObservers();
    }

    @Override
    public void removeSong(int index) {
        this.songs.remove(index);
        notifyObservers();

    }

    @Override
    public void moveSong(int oldIndex, int newIndex) {
        Song song = this.songs.remove(oldIndex);
        this.songs.add(newIndex, song);
        notifyObservers();

    }

    @Override
    public void shuffleSongs() {
        Collections.shuffle(this.songs);
        notifyObservers();

    }

    @Override
    public int getNumSongs() {
        return this.songs.size();
    }

    @Override
    public void addObserver(PlaylistObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(PlaylistObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public Iterator<Song> iterator() {
        return this.songs.iterator();
    }

    private void notifyObservers(){
        for(PlaylistObserver o : observers){
            o.update(this);
        }
    }
}
