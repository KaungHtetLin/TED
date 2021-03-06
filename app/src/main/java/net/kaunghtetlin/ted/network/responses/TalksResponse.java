package net.kaunghtetlin.ted.network.responses;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.vos.TalksVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/25/2018.
 */

public class TalksResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("ted_talks")
    private List<TalksVO> talksList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<TalksVO> getTalksList() {
        return talksList;
    }
}
