package com.example.toor.movieviewer.core.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toor.movieviewer.viewmodel.MainViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<M extends ViewModel, B extends ViewDataBinding> extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    @CallSuper
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureDagger();
        configureViewModel();
    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel() {
        ViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        return binding.getRoot();
    }

    protected abstract Class<M> getViewModel();

    protected abstract
    @LayoutRes
    int getLayoutResId();
}
