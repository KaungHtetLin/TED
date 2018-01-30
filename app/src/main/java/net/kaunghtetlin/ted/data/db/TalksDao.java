package net.kaunghtetlin.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import net.kaunghtetlin.ted.data.vos.TalksVO;

import java.util.List;

import static net.kaunghtetlin.ted.data.db.DBConstants.TALKS_TABLE;

/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

@Dao
public interface TalksDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTalk(TalksVO talk);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTalks(TalksVO... talks);

    @Query("SELECT * FROM " + TALKS_TABLE)
    LiveData<List<TalksVO>> getAllTalks();

    @Query("DELETE FROM " + TALKS_TABLE)
    void deleteAll();
}
