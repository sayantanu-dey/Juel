package com.voile.jule.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.voile.jule.database.dao.PlaylistDao;
import com.voile.jule.database.model.PlaylistEntity;

@Database(
        entities = PlaylistEntity.class,
        exportSchema = false,
        version = 1
)
@TypeConverters({Converters.class})
public abstract class PlaylistDatabase extends RoomDatabase {
    private static final String DB_NAME = "playlist_table";
    private static final Object LOCK = new Object();
    private static PlaylistDatabase instance;

    public static synchronized PlaylistDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(), PlaylistDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return instance;
    }

    public abstract PlaylistDao playlistDao();

}
