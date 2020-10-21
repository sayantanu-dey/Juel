package com.voile.jule.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Size;

import java.io.IOException;

public class Song implements Media {
    private String Album;
    private String Track;
    private double duration;
    private Uri uri;

    public String getAlbum() {
        return Album;
    }

    public String getTrack() {
        return Track;
    }

    public double getDuration() {
        return duration;
    }

    public Uri getUri() {
        return uri;
    }

    public String getArtist() {
        return artist;
    }

    private String artist;

    public Song(Uri uri, String track, String artist , String album, double duration) {
        Album = album;
        Track = track;
        this.duration = duration;
        this.uri = uri;
        this.artist = artist;
    }

    public Song(Uri uri , String track, double duration) {
        Track = track;
        this.duration = duration;
        this.uri = uri;
        this.Album = "Unknown";
        this.artist = "Unknown";
    }

    public Song(Uri uri, String track, String artist, double duration) {
        Track = track;
        this.duration = duration;
        this.uri = uri;
        this.artist = artist;
        this.Album = "Unknown";
    }

    public Bitmap getThumbnail(Context context,int width, int height) throws IOException {
        Bitmap thumbnail = context.getContentResolver().loadThumbnail(
                        uri, new Size(width, height), null);
        return thumbnail;
    }

    @Override
    public void play(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(context,uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pause(Context context) {

//        /*Todo*/
//        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void restart(Context context) {
//        /*Todo*/
//        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Song(Parcel in){
        uri = Uri.parse(in.readString());
        Track = in.readString();
        artist = in.readString();
        Album = in.readString();
        duration = in.readDouble();
        //Uri uri, String track, String artist , String album, double duration
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(String.valueOf(this.uri));
        dest.writeString(Track);
        dest.writeString(artist);
        dest.writeString(Album);
        dest.writeDouble(duration);
    }

    public static final Parcelable.Creator<Song> CREATOR  = new Parcelable.Creator<Song>(){

        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
