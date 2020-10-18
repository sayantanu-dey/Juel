package com.voile.jule.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.voile.jule.data.api.YoutubeInterface;
import com.voile.jule.data.model.Video;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class YoutubeDataSource extends PageKeyedDataSource<String, Video> {
    private YoutubeInterface apiService;
    private CompositeDisposable compositeDisposable;

    private String query = "";
    public static MutableLiveData<NetworkState> networkState = new MutableLiveData<NetworkState>();

    public YoutubeDataSource(YoutubeInterface apiService, CompositeDisposable compositeDisposable, String query) {
        this.apiService = apiService;
        this.compositeDisposable = compositeDisposable;
        this.query = query;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull LoadInitialCallback<String, Video> callback) {
        networkState.postValue(NetworkState.LOADING);
        compositeDisposable.add(
                apiService.getSearchResult(query,"")
                        .subscribeOn(Schedulers.io())
                        .subscribe(videoResponse -> {
                            String nextPageKey = videoResponse.nextPageToken;
                            callback.onResult(videoResponse.videos,null,nextPageKey);
                            networkState.postValue(NetworkState.LOADED);
                        },throwable -> {
                            networkState.postValue(NetworkState.ERROR);
                            Log.e("VideoDataSource",throwable.getMessage()+"");
                        })
        );
    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Video> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<String> params, @NonNull LoadCallback<String, Video> callback) {
        networkState.postValue(NetworkState.LOADING);
        compositeDisposable.add(
                apiService.getSearchResult(query,params.key)
                        .subscribeOn(Schedulers.io())
                        .subscribe(videoResponse -> {
                            String nextPageKey = videoResponse.nextPageToken;
                            callback.onResult(videoResponse.videos,nextPageKey);
                            networkState.postValue(NetworkState.LOADED);
                        },throwable -> {
                            networkState.postValue(NetworkState.ERROR);
                            Log.e("VideoDataSource",throwable.getMessage()+"");
                        })
        );
    }
}
