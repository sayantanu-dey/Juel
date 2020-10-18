package com.voile.jule.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.voile.jule.data.api.YoutubeInterface;
import com.voile.jule.data.model.Video;

import io.reactivex.disposables.CompositeDisposable;

public class YoutubeDataSourceFactory extends DataSource.Factory<String, Video> {

    public MutableLiveData<YoutubeDataSource> youtubeLiveDataSource = new MutableLiveData<>();
    private YoutubeInterface apiService;
    private CompositeDisposable compositeDisposable;
    private String query;

    public YoutubeDataSourceFactory(YoutubeInterface apiService, CompositeDisposable compositeDisposable, String query) {
        this.apiService = apiService;
        this.compositeDisposable = compositeDisposable;
        this.query = query;
    }

    @NonNull
    @Override
    public DataSource<String, Video> create() {
        YoutubeDataSource youtubeDataSource = new YoutubeDataSource(apiService,compositeDisposable,query);
        youtubeLiveDataSource.postValue(youtubeDataSource);
        return youtubeDataSource;
    }
}