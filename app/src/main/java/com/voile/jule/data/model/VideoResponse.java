package com.voile.jule.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoResponse {
    @SerializedName("nextPageToken")
    public String nextPageToken;

    @SerializedName("items")
    public List<Video> videos;

    @SerializedName("pageInfo")
    public PageInfo pageInfo;
}
