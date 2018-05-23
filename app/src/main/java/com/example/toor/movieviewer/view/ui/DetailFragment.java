package com.example.toor.movieviewer.view.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.toor.movieviewer.R;
import com.example.toor.movieviewer.core.base.BaseFragment;
import com.example.toor.movieviewer.databinding.DetailFragmentBinding;
import com.example.toor.movieviewer.viewmodel.DetailViewModel;

import dagger.android.support.AndroidSupportInjection;

public class DetailFragment extends BaseFragment<DetailViewModel, DetailFragmentBinding> {

    private DetailFragmentBinding binding;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    protected void getBinding(DetailFragmentBinding binding) {
        this.binding = binding;
    }

    @Override
    protected Class<DetailViewModel> getViewModel() {
        return DetailViewModel.class;
    }

    @Override
    protected void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, DetailViewModel viewModel) {
        sharedViewModel.getSelected().observe(this, movie -> {
            binding.setDescription(movie);
            binding.setImage(movie.getMultimedia());
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.detail_fragment;
    }
}
