package net.kaunghtetlin.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import net.kaunghtetlin.ted.data.vos.PlaylistsVO;

import java.util.List;

import static net.kaunghtetlin.ted.data.db.DBConstants.PLAYLISTS_TABLE;

/**
 * Created by Kaung Htet Lin on 1/31/2018.
 */

@Dao
public interface PlayListsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPlaylists(PlaylistsVO playlist);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertPlaylists(PlaylistsVO... playlists);

    @Query("SELECT * FROM " + PLAYLISTS_TABLE)
    LiveData<List<PlaylistsVO>> getAllPlaylists();

    @Query("DELETE FROM " + PLAYLISTS_TABLE)
    void deleteAll();
}
