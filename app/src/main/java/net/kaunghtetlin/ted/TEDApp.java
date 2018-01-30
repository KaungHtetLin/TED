package net.kaunghtetlin.ted;

import android.app.Application;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.kaunghtetlin.ted.network.TedApi;
import net.kaunghtetlin.ted.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kaung Htet Lin on 1/23/2018.
 */

public class TEDApp extends Application {

    public static final String LOG_TAG = "TEDApp";

    public static TedApi theApi;

    @Override
    public void onCreate() {
        super.onCreate();
        initTedApi();
    }

    private void initTedApi() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.TED_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TedApi.class);
    }

    public static TedApi getApi() {
        return theApi;
    }
}
