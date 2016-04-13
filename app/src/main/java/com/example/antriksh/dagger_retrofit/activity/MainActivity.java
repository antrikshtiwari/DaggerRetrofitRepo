package com.example.antriksh.dagger_retrofit.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.antriksh.dagger_retrofit.MainView;
import com.example.antriksh.dagger_retrofit.R;
import com.example.antriksh.dagger_retrofit.api.YourApi;
import com.example.antriksh.dagger_retrofit.application.DaggerRetrofitApp;
import com.example.antriksh.dagger_retrofit.module.MainActivityModule;
import com.example.antriksh.dagger_retrofit.presenter.MainActivityPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainActivityPresenter presenter;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private final String GET_SUCCESS = "Success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);
    }

    @Override
    protected void setupActivityComponent() {

        DaggerRetrofitApp.get(this)
                .getAppComponent()
                .plus(new MainActivityModule(this))
                .inject(this);
    }

    @OnClick(R.id.fab)
    void onGetRequest(){

        String query = "queryParam";
        String pathParam = "pathParam";

        //Call server
        retrofit.dummyGetRequest(query, pathParam).enqueue(new Callback<ArrayList<YourApi>>() {
            @Override
            public void onResponse(Call<ArrayList<YourApi>> call, Response<ArrayList<YourApi>> response) {
                //handle success
                sharedPreferences.edit().putBoolean(GET_SUCCESS, true).commit();
            }

            @Override
            public void onFailure(Call<ArrayList<YourApi>> call, Throwable t) {
                //handle failure
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onEnteredBackground();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onEnteredForeground();
    }

    @Override
    public void setOnView() {
        //textview.setText();
    }
}
