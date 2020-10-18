package com.voile.jule.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.voile.jule.media.Playlist;

public class Converters {
    @TypeConverter
    public static Playlist playlistFromDatabase(String json){
        if(json==null)return null;
        Gson gson = new Gson();
        Playlist playlist = gson.fromJson(json,Playlist.class);
        return playlist;
    }

    @TypeConverter
    public static String songToString(Playlist playlist){
        if(playlist==null)return null;
        Gson gson = new Gson();
        String json = gson.toJson(playlist);
        return json;
    }
}
