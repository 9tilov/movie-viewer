package com.example.toor.movieviewer.di.module;

import com.example.toor.movieviewer.view.ui.DetailFragment;
import com.example.toor.movieviewer.view.ui.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Philippe on 02/03/2018.
 */

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();

    @ContributesAndroidInjector
    abstract DetailFragment contributeDetailFragment();
}
