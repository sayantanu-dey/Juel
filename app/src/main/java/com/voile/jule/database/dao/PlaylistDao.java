package com.voile.jule.database.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.voile.jule.database.model.PlaylistEntity;
import com.voile.jule.media.Playlist;

import java.util.List;

@Dao
public interface PlaylistDao {
    @Insert
    void insert(PlaylistEntity entity);

    @Update
    void update(PlaylistEntity entity);

    @Delete
    void delete(PlaylistEntity entity);

    @Query("Delete from playlist_table")
    void deleteAll();

    @Query("Select * from playlist_table")
    LiveData<List<PlaylistEntity>> getAllPlaylist();
}
