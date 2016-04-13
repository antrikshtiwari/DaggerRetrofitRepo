package com.example.antriksh.dagger_retrofit.module;

import com.example.antriksh.dagger_retrofit.MainView;
import com.example.antriksh.dagger_retrofit.activity.ActivityScope;
import com.example.antriksh.dagger_retrofit.presenter.MainActivityPresenter;
import com.example.antriksh.dagger_retrofit.presenter.MainActivityPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
@Module
public class MainActivityModule {

    private MainView mainView;

    public MainActivityModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenterImpl(mainView);
    }
}
