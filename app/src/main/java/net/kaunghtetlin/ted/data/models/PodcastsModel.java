package net.kaunghtetlin.ted.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import net.kaunghtetlin.ted.TEDApp;
import net.kaunghtetlin.ted.data.db.AppDatabase;
import net.kaunghtetlin.ted.data.vos.PodcastsVO;
import net.kaunghtetlin.ted.network.responses.PodcastsResponse;
import net.kaunghtetlin.ted.utils.AppConstants;

import java.util.List;

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

public class PodcastsModel extends ViewModel{

    Observable<PodcastsResponse> podcastsListResponseObservable;
        private AppDatabase mAppDatabase;
    private MutableLiveData<List<PodcastsVO>> mPodcasts;

    public PodcastsModel() {
//        initTedApi();
        mPodcasts = new MutableLiveData<>();
        LoadTalks();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<PodcastsVO>> getPodcastsList() {
//        return mPodcasts;
        return mAppDatabase.podcastsDao().getAllPodcasts();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    public void LoadTalks() {
        podcastsListResponseObservable = TEDApp.getApi().getPodcasts(AppConstants.ACCESS_TOKEN, 1);
        podcastsListResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .map(new Function<PodcastsResponse, List<PodcastsVO>>() {
                    @Override
                    public List<PodcastsVO> apply(@NonNull PodcastsResponse podcastsResponse) throws Exception {
                        return podcastsResponse.getPodcastsLists();
                    }
                })
                .subscribe(new Observer<List<PodcastsVO>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<PodcastsVO> podcastsList) {
                        mAppDatabase.podcastsDao().deleteAll();
                        long[] insertedIds = mAppDatabase.podcastsDao().insertPodcasts(podcastsList.toArray(new PodcastsVO[0]));
                        Log.d(TEDApp.LOG_TAG, "Total inserted podcasts count : " + insertedIds.length);
//                        mPodcasts.setValue(podcastsList);
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
