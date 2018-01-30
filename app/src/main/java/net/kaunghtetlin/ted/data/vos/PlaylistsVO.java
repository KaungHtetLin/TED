package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;
import net.kaunghtetlin.ted.data.db.GsonToListTalksConvector;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

@Entity(tableName = DBConstants.PLAYLISTS_TABLE)
@TypeConverters(GsonToListTalksConvector.class)
public class PlaylistsVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("playlist_id")
    private int playlistId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("totalTalks")
    private int totalTalks;

    @SerializedName("description")
    private String description;

    @SerializedName("talksInPlaylist")
    private List<TalksVO> talksInPlayList;

    public long getId() {
        return id;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public List<TalksVO> getTalksInPlayList() {
        return talksInPlayList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTotalTalks(int totalTalks) {
        this.totalTalks = totalTalks;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTalksInPlayList(List<TalksVO> talksInPlayList) {
        this.talksInPlayList = talksInPlayList;
    }
}
