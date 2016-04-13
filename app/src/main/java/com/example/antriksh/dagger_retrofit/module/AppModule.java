package com.example.antriksh.dagger_retrofit.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import com.example.antriksh.dagger_retrofit.api.ApplicationAPI;
import com.example.antriksh.dagger_retrofit.application.DaggerRetrofitApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
@Module
public class AppModule {

    private final DaggerRetrofitApp daggerRetrofitApp;

    public static final HttpUrl API_URL = HttpUrl.parse("https://your-base-url.com");

    public AppModule(DaggerRetrofitApp daggerRetrofitApp){
        this.daggerRetrofitApp = daggerRetrofitApp;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(daggerRetrofitApp);
    }

    @Provides
    @Singleton
    ApplicationAPI provideRetrofitClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(ApplicationAPI.class);
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) daggerRetrofitApp.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
