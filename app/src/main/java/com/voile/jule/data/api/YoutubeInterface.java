package com.voile.jule.data.api;

import com.voile.jule.data.model.VideoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeInterface {
    @GET("search?part=snippet&maxResults=50&type=video")
    Single<VideoResponse> getSearchResult(@Query("q") String query, @Query("pageToken") String pageToken);
}
