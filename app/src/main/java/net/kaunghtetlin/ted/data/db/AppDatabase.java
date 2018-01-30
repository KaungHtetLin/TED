package net.kaunghtetlin.ted.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.kaunghtetlin.ted.data.vos.PlaylistsVO;
import net.kaunghtetlin.ted.data.vos.PodcastsVO;
import net.kaunghtetlin.ted.data.vos.SpeakerVO;
import net.kaunghtetlin.ted.data.vos.TagVO;
import net.kaunghtetlin.ted.data.vos.TalksVO;

/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

@Database(entities = {TalksVO.class, PlaylistsVO.class, PodcastsVO.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "TEDAPP.DB";

    private static AppDatabase INSTANCE;

    public abstract TalksDao talksDao();
    public abstract PodcastsDao podcastsDao();
    public abstract PlayListsDao playListsDao();

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}