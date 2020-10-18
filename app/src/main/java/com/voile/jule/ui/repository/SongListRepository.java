package com.voile.jule.ui.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.voile.jule.dao.DeviceMediaFetch;
import com.voile.jule.media.Song;

import java.util.List;

public class SongListRepository {
    private MutableLiveData<List<Song>> songList = new MutableLiveData<>();
    private Context context;

    public SongListRepository(Context context) {
        this.context = context;
    }

    public LiveData<List<Song>> fetchDeviceSongs(){
        songList.setValue(DeviceMediaFetch.getDeviceSongs(context));
        return songList;
    }
}
