package com.voile.jule.ui.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.voile.jule.database.PlaylistDatabase;
import com.voile.jule.database.model.PlaylistEntity;
import com.voile.jule.media.Playlist;

import java.util.List;

public class DatabaseRepository {
    private PlaylistDatabase playlistDatabase;

    public DatabaseRepository(Context context){
        playlistDatabase = PlaylistDatabase.getInstance(context);
    }

    public LiveData<List<PlaylistEntity>> fetchAllPlaylists(){
       return playlistDatabase.playlistDao().getAllPlaylist();
    }

    @SuppressLint("StaticFieldLeak")
    @SuppressWarnings("deprecation")
    public void insert(PlaylistEntity playlist){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                playlistDatabase.playlistDao().insert(playlist);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    @SuppressWarnings("deprecation")
    public void update(PlaylistEntity playlist){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                playlistDatabase.playlistDao().update(playlist);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    @SuppressWarnings("deprecation")
    public void delete(PlaylistEntity playlist){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                playlistDatabase.playlistDao().delete(playlist);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    @SuppressWarnings("deprecation")
    public void deleteAll(){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                playlistDatabase.playlistDao().deleteAll();
                return null;
            }
        }.execute();
    }
}
