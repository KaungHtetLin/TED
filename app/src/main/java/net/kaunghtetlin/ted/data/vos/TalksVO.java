package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;
import net.kaunghtetlin.ted.data.db.GsonToListTagConvector;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

@Entity(tableName = DBConstants.TALKS_TABLE)
@TypeConverters(GsonToListTagConvector.class)
public class TalksVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("talk_id")
    private String talk_id;

    @SerializedName("title")
    private String title;

    @Embedded
    @SerializedName("speaker")
    private SpeakerVO speaker;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("durationInSec")
    private int duriationInSec;

    @SerializedName("description")
    private String description;

    @SerializedName("tag")
    private List<TagVO> tag;

    public long getId() {
        return id;
    }

    public String getTalk_id() {
        return talk_id;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDuriationInSec() {
        return duriationInSec;
    }

    public String getDescription() {
        return description;
    }

    public List<TagVO> getTag() {
        return tag;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTalk_id(String talk_id) {
        this.talk_id = talk_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSpeaker(SpeakerVO speaker) {
        this.speaker = speaker;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDuriationInSec(int duriationInSec) {
        this.duriationInSec = duriationInSec;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTag(List<TagVO> tag) {
        this.tag = tag;
    }
}
