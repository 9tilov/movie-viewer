package com.example.toor.movieviewer.view.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.toor.movieviewer.R;
import com.example.toor.movieviewer.core.base.BaseFragment;
import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.view.adapter.MovieAdapter;
import com.example.toor.movieviewer.viewmodel.MainViewModel;

import timber.log.Timber;

public class MainFragment extends BaseFragment<MainViewModel, ViewDataBinding> implements MovieAdapter.ItemSelectedListener {

    private ViewDataBinding binding;
    private MovieAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MovieAdapter();
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.main_fragment;
    }

    @Override
    public void onItemSelected(Movie item) {
        Timber.d("click");
    }
}
