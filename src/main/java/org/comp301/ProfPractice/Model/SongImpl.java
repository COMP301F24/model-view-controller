package org.comp301.ProfPractice.Model;

public class SongImpl implements Song{
    private String title;
    private String artist;
    private int rating;


    public SongImpl(String title, String artist, int rating){
        this.title = title;
        this.artist = artist;
        this.rating = rating;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getArtist() {
        return this.artist;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public String toString(){
        String retval =  this.title + " by " + this.artist + "(";

        for(int i=0;i<this.rating;i++){
            retval += "\u2605";
        }

        for(int i=this.rating ;i<5;i++){
            retval += "\u2606";
        }

        retval += ")";
        return retval;
    }
}
