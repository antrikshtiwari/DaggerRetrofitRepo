package com.example.antriksh.dagger_retrofit.application;

import android.app.Application;
import android.content.Context;

import com.example.antriksh.dagger_retrofit.component.AppComponent;
import com.example.antriksh.dagger_retrofit.component.DaggerAppComponent;
import com.example.antriksh.dagger_retrofit.module.AppModule;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
public class DaggerRetrofitApp extends Application {

    private AppComponent appComponent;

    private static DaggerRetrofitApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeAppComponent();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initializeAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static DaggerRetrofitApp get(Context context) {
        return (DaggerRetrofitApp) context.getApplicationContext();
    }
}
