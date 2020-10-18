package com.voile.jule.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.voile.jule.ui.repository.DatabaseRepository;
import com.voile.jule.database.model.PlaylistEntity;

import java.util.List;

public class PlaylistFragmentViewModel extends ViewModel {
    private DatabaseRepository repository;
    public void setRepository(DatabaseRepository repository){
        this.repository = repository;
    }

    private LiveData<List<PlaylistEntity>> playlistList;

    public LiveData<List<PlaylistEntity>> fetchPlaylists(){
        playlistList = repository.fetchAllPlaylists();
        return playlistList;
    }

    public boolean listIsEmpty(){
        if(playlistList.getValue()!=null){
            return playlistList.getValue().isEmpty();
        }
        return true;
    }
}
