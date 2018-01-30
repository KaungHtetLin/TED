package net.kaunghtetlin.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.kaunghtetlin.ted.data.vos.PodcastsVO;

import java.util.List;

import static net.kaunghtetlin.ted.data.db.DBConstants.PODCASTS_TABLE;

/**
 * Created by Kaung Htet Lin on 1/31/2018.
 */

@Dao
public interface PodcastsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPodcast(PodcastsVO podcast);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertPodcasts(PodcastsVO... podcasts);

    @Query("SELECT * FROM " + PODCASTS_TABLE)
    LiveData<List<PodcastsVO>> getAllPodcasts();

    @Query("DELETE FROM " + PODCASTS_TABLE)
    void deleteAll();

}
