package net.kaunghtetlin.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.db.DBConstants;


/**
 * Created by Kaung Htet Lin on 1/25/2018.
 */

@Entity(tableName = DBConstants.SPEAKER_TABLE)
public class SpeakerVO {

    @PrimaryKey
    @SerializedName("speaker_id")
    private String speakerId;

    @SerializedName("name")
    private String speakerName;

    public String getSpeakerId() {
        return speakerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerId(String speakerId) {
        this.speakerId = speakerId;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
}
