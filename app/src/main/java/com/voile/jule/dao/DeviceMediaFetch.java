package com.voile.jule.dao;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;

import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.voile.jule.media.Song;

import java.util.ArrayList;
import java.util.List;

public class DeviceMediaFetch {

    private DeviceMediaFetch() {}

    public static List<Song> getDeviceSongs(Context context) {

        List<Song> deviceSongs = new ArrayList<>();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String projection[] = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION,
        };
        Cursor cursor = context.getContentResolver().query(uri,projection,null,null,null);

        if(cursor!=null){
            while (cursor.moveToNext()){
                Long id = cursor.getLong(0);
                String title = cursor.getString(1);
                String artist = cursor.getString(2);
                String album = cursor.getString(3);
                Double duration = cursor.getDouble(4);
                Uri contentUri = ContentUris.withAppendedId(uri, id);

                Song song = new Song(contentUri,title,artist,album,duration);
                deviceSongs.add(song);
            }
        }
        Log.i(">>",deviceSongs.get(0).getArtist());
        return deviceSongs;
    }
}
