package com.aks.sampleapplication.ui.main.view_model;

import androidx.lifecycle.ViewModel;

import com.aks.sampleapplication.utils.BaseUtilsClass;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class MainViewModel extends ViewModel {
    CompositeDisposable disposable;
    @Inject
    BaseUtilsClass baseUtilsClass;

    @Inject
    public MainViewModel() {
        disposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
