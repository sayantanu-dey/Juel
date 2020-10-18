package com.voile.jule.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.voile.jule.media.Song;
import com.voile.jule.ui.repository.SongListRepository;

import java.util.List;

public class MusicFragmentViewModel extends ViewModel {
    private SongListRepository repository;

    public MusicFragmentViewModel() { }

    public void setRepository(SongListRepository repository) {
        this.repository = repository;
    }

    private LiveData<List<Song>> deviceSongList;

    public LiveData<List<Song>> getAllDeviceSongs(){
        deviceSongList = repository.fetchDeviceSongs();
        return deviceSongList;
    }

    public boolean listIsEmpty(){
        if(deviceSongList.getValue()!=null){
            return deviceSongList.getValue().isEmpty();
        }
        return true;
    }
}
