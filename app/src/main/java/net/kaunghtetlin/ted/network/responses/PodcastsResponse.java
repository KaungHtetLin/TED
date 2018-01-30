package net.kaunghtetlin.ted.network.responses;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.vos.PodcastsVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

public class PodcastsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String pageNo;

    @SerializedName("ted_podcasts")
    private List<PodcastsVO> podcastsLists;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPageNo() {
        return pageNo;
    }

    public List<PodcastsVO> getPodcastsLists() {
        return podcastsLists;
    }
}
