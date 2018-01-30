package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;
import net.kaunghtetlin.ted.data.db.GsonToListSegmentsConvector;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

@Entity(tableName = DBConstants.PODCASTS_TABLE)
@TypeConverters(GsonToListSegmentsConvector.class)
public class PodcastsVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("podcast_id")
    private int podcastsId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("segments")
    private List<SegmentsVO> segmentsVOS;

    public long getId() {
        return id;
    }

    public int getPodcastsId() {
        return podcastsId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<SegmentsVO> getSegmentsVOS() {
        return segmentsVOS;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPodcastsId(int podcastsId) {
        this.podcastsId = podcastsId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSegmentsVOS(List<SegmentsVO> segmentsVOS) {
        this.segmentsVOS = segmentsVOS;
    }

}
