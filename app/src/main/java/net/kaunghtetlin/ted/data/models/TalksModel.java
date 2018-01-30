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
import net.kaunghtetlin.ted.data.db.TalksDao;
import net.kaunghtetlin.ted.data.vos.TalksVO;
import net.kaunghtetlin.ted.network.TedApi;
import net.kaunghtetlin.ted.network.responses.TalksResponse;
import net.kaunghtetlin.ted.utils.AppConstants;


import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kaung Htet Lin on 1/25/2018.
 */

public class TalksModel extends ViewModel {

//    private TedApi theApi;
    Observable<TalksResponse> talksResponseObservable;
    private AppDatabase mAppDatabase;
    private MutableLiveData<List<TalksVO>> mtalks;

    public TalksModel() {
//        initTedApi();
        mtalks = new MutableLiveData<>();
        LoadTalks();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<TalksVO>> getTalks() {
        return mAppDatabase.talksDao().getAllTalks();
//        return mtalks;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    public void LoadTalks()
    {
        talksResponseObservable=TEDApp.getApi().getTalksList(AppConstants.ACCESS_TOKEN,1);
        talksResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .map(new Function<TalksResponse, List<TalksVO>>() {
                    @Override
                    public List<TalksVO> apply(@NonNull TalksResponse talksResponse) throws Exception {
                        return talksResponse.getTalksList();
                    }
                })
                .subscribe(new Observer<List<TalksVO>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<TalksVO> talksVOS) {
                        mAppDatabase.talksDao().deleteAll();
                        long[] insertedIds = mAppDatabase.talksDao().insertTalks(talksVOS.toArray(new TalksVO[0]));
                        Log.d(TEDApp.LOG_TAG, "Total inserted talks count : " + insertedIds.length);
//                        mtalks.setValue(talksVOS);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TEDApp.LOG_TAG,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}


