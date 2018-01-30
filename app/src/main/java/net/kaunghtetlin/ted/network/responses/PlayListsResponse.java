package net.kaunghtetlin.ted.network.responses;

import com.google.gson.annotations.SerializedName;

import net.kaunghtetlin.ted.data.vos.PlaylistsVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

public class PlayListsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String pageNo;

    @SerializedName("ted_playlists")
    private List<PlaylistsVO> playlists;

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

    public List<PlaylistsVO> getPlaylists() {
        return playlists;
    }
}
