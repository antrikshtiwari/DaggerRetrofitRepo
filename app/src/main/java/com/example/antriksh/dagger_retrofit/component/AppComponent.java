package com.example.antriksh.dagger_retrofit.component;

import android.content.SharedPreferences;

import com.example.antriksh.dagger_retrofit.api.ApplicationAPI;
import com.example.antriksh.dagger_retrofit.module.AppModule;
import com.example.antriksh.dagger_retrofit.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {

        ApplicationAPI provideRetrofitClient();

        MainActivityComponent plus(MainActivityModule module);

        SharedPreferences provideSharedPrefs();
}
