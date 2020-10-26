package com.voile.jule.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class JuleMediaPlayer{
    private static JuleMediaPlayer instance;
    private JuleMediaPlayer(){}
    private static MediaPlayer mediaPlayer;
    private static Context context;
    private Song song;
    public static JuleMediaPlayer getInstance(Context c) {
        if(instance == null){
            instance = new JuleMediaPlayer();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(
                    new AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .build()
            );
            context = c;
        }
        return instance;
    }


    public void play(){
        mediaPlayer.start();
    }

    public void LoadSong(Song song) throws IOException {
        this.song = song;
        mediaPlayer.reset();
        mediaPlayer.setDataSource(context,song.getUri());
        mediaPlayer.prepare();
    }

    public void stop(){
        mediaPlayer.reset();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public Song getCurrentSong(){
        return song;
    }

}
