package com.example.antriksh.dagger_retrofit.component;

import com.example.antriksh.dagger_retrofit.activity.ActivityScope;
import com.example.antriksh.dagger_retrofit.activity.MainActivity;
import com.example.antriksh.dagger_retrofit.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by antrikshtiwari on 11/04/16.
 */
@ActivityScope
@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);
}
