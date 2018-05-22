package com.example.toor.movieviewer.view.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.toor.movieviewer.R;
import com.example.toor.movieviewer.core.base.BaseFragment;
import com.example.toor.movieviewer.databinding.MainFragmentBinding;
import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.view.adapter.MovieAdapter;
import com.example.toor.movieviewer.viewmodel.MainViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class MainFragment extends BaseFragment<MainViewModel, ViewDataBinding> implements MovieAdapter.ItemSelectedListener {

    private MovieAdapter adapter;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private MainViewModel viewModel;
    private MainFragmentBinding binding;

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
    protected void getBinding(ViewDataBinding binding) {
        this.binding = (MainFragmentBinding) binding;
    }

    @Override
    protected void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    protected void configureViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        binding.recyclerView.setAdapter(adapter);
        viewModel.getMovieList().observe(this, movies -> {
            adapter.setData(movies);
            Timber.d("Size = " + movies.size());
        });
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
