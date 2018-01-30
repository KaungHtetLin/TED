package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

@Entity(tableName = DBConstants.SEGMENTS_TABLE)
public class SegmentsVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("segment_id")
    private String segmentId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    public long getId() {
        return id;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
