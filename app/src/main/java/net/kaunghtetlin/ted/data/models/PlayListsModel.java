package net.kaunghtetlin.ted.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.kaunghtetlin.ted.TEDApp;
import net.kaunghtetlin.ted.data.db.AppDatabase;
import net.kaunghtetlin.ted.data.vos.PlaylistsVO;
import net.kaunghtetlin.ted.network.TedApi;
import net.kaunghtetlin.ted.network.responses.PlayListsResponse;
import net.kaunghtetlin.ted.utils.AppConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Kaung Htet Lin on 1/26/2018.
 */

public class PlayListsModel extends ViewModel {

    //    private TedApi theApi;
    Observable<PlayListsResponse> playListsResponseObservable;
    private AppDatabase mAppDatabase;
    private MutableLiveData<List<PlaylistsVO>> mPlaylists;

    public PlayListsModel() {
//        initTedApi();
        mPlaylists = new MutableLiveData<>();
        LoadTalks();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<PlaylistsVO>> getPlayLists() {
//        return mPlaylists;
        return mAppDatabase.playListsDao().getAllPlaylists();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    public void LoadTalks() {
        playListsResponseObservable = TEDApp.getApi().getPlayLists(AppConstants.ACCESS_TOKEN, 1);
        playListsResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .map(new Function<PlayListsResponse, List<PlaylistsVO>>() {
                    @Override
                    public List<PlaylistsVO> apply(@NonNull PlayListsResponse playlistsResponse) throws Exception {
                        return playlistsResponse.getPlaylists();
                    }
                })
                .subscribe(new Observer<List<PlaylistsVO>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<PlaylistsVO> playlistsVOS) {
                        mAppDatabase.playListsDao().deleteAll();
                        long[] insertedIds = mAppDatabase.playListsDao().insertPlaylists(playlistsVOS.toArray(new PlaylistsVO[0]));
                        Log.d(TEDApp.LOG_TAG, "Total inserted podcasts count : " + insertedIds.length);
//                        mPlaylists.setValue(playlistsVOS);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TEDApp.LOG_TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
