package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;

/**
 * Created by Kaung Htet Lin on 1/25/2018.
 */

@Entity(tableName = DBConstants.TAG_TABLE)
public class TagVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("tag_id")
    private int tagId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String description;

    public long getId() {
        return id;
    }

    public int getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
