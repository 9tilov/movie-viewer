package com.example.toor.movieviewer.core.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toor.movieviewer.viewmodel.SharedViewModel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<M extends ViewModel, B extends ViewDataBinding> extends Fragment {

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;
    protected SharedViewModel sharedViewModel;

    @Override
    public void onAttach(Context context) {
        configureDagger();
        super.onAttach(context);
    }

    @SuppressWarnings("unchecked")
    @SuppressLint("CheckResult")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        getBinding((B) binding);
        return binding.getRoot();
    }

    @SuppressWarnings("unchecked")
    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel());
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        onViewCreated(view, savedInstanceState, (M) viewModel);
    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    protected abstract void getBinding(B binding);

    protected abstract Class<M> getViewModel();

    protected abstract void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, M viewModel);

    protected abstract
    @LayoutRes
    int getLayoutResId();
}
