package com.example.toor.movieviewer.view.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.toor.movieviewer.R;
import com.example.toor.movieviewer.core.base.BaseFragment;
import com.example.toor.movieviewer.databinding.MainFragmentBinding;
import com.example.toor.movieviewer.model.data.Movie;
import com.example.toor.movieviewer.view.adapter.MovieAdapter;
import com.example.toor.movieviewer.viewmodel.MainViewModel;

import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

public class MainFragment extends BaseFragment<MainViewModel, MainFragmentBinding> implements MovieAdapter.ItemSelectedListener {

    private MovieAdapter adapter;
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
    protected void getBinding(MainFragmentBinding binding) {
        this.binding = binding;
    }

    @Override
    protected Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, MainViewModel viewModel) {
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
        sharedViewModel.select(item);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance())
                .addToBackStack(null)
                .commit();
        Timber.d("click");
    }
}
