package net.kaunghtetlin.ted.network;

import net.kaunghtetlin.ted.network.responses.PlayListsResponse;
import net.kaunghtetlin.ted.network.responses.PodcastsResponse;
import net.kaunghtetlin.ted.network.responses.TalksResponse;
import net.kaunghtetlin.ted.utils.AppConstants;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Kaung Htet Lin on 1/25/2018.
 */

public interface TedApi {

    /*@POST(AppConstants.API_GET_TALKS_LISTS)
    Observable<TalksResponse> getTalksList();
    @Field("access_token") String accessToken,
    @Field("page") int pageIndex);
*/
    @FormUrlEncoded
    @POST(AppConstants.API_GET_TALKS_LISTS)
    Observable<TalksResponse> getTalksList(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);

    @FormUrlEncoded
    @POST(AppConstants.API_GET_PLAYLISTS_LISTS)
    Observable<PlayListsResponse> getPlayLists(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);

    @FormUrlEncoded
    @POST(AppConstants.API_GET_PODCASTS_LISTS)
    Observable<PodcastsResponse> getPodcasts(
            @Field("access_token") String accessToken,
            @Field("page") int pageIndex);

}
