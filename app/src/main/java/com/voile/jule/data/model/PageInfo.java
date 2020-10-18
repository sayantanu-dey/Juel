package com.voile.jule.data.model;

import com.google.gson.annotations.SerializedName;

public class PageInfo {
    @SerializedName("totalResults")
    public Long totalResults;

    @SerializedName("resultsPerPage")
    public int resultPerPage;
}
