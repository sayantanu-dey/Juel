package com.voile.jule.media;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Media {

    public ArrayList<Song> songs = new ArrayList<>();
    private String name;
    public void addSong(Song song){
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public Playlist(String name) {
        this.name = name;
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

    @Override
    public void play(Context context) {
        /*Todo*/
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pause(Context context) {
        /*Todo*/
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void restart(Context context) {
        /*Todo*/
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Playlist(Parcel in){
        this.name = in.readString();
        this.songs = in.readArrayList(null);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeList(songs);
    }

    public static final Parcelable.Creator<Playlist> CREATOR  = new Parcelable.Creator<Playlist>(){

        @Override
        public Playlist createFromParcel(Parcel source) {
            return new Playlist(source);
        }

        @Override
        public Playlist[] newArray(int size) {
            return new Playlist[size];
        }
    };
}
