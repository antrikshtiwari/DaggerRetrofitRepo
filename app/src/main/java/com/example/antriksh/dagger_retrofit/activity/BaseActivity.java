package com.example.antriksh.dagger_retrofit.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.antriksh.dagger_retrofit.R;
import com.example.antriksh.dagger_retrofit.api.ApplicationAPI;
import com.example.antriksh.dagger_retrofit.application.DaggerRetrofitApp;
import com.example.antriksh.dagger_retrofit.component.AppComponent;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    ApplicationAPI retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected abstract void setupActivityComponent();

    public AppComponent getAppComponent() {
        return DaggerRetrofitApp.get(this).getAppComponent();
    }
}
