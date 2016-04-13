package com.example.antriksh.dagger_retrofit.presenter;

import com.example.antriksh.dagger_retrofit.MainView;

/**
 * Created by antrikshtiwari on 12/04/16.
 */
public class MainActivityPresenterImpl implements MainActivityPresenter {

    MainView mainView;

    public MainActivityPresenterImpl(MainView mainView){
        this.mainView = mainView;

    }

    @Override
    public void onEnteredForeground() {
        //  Do stuffs which you want to do onResume
        mainView.setOnView();
    }

    @Override
    public void onEnteredBackground() {
        // Do stuffs which you want to do onStop
    }

}
