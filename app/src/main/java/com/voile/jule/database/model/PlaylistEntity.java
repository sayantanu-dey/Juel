package com.voile.jule.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.voile.jule.media.Playlist;

@Entity(tableName = "playlist_table")
public class PlaylistEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private Playlist playlist;

    public PlaylistEntity(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }
}
