package com.aks.sampleapplication.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aks.sampleapplication.data.BaseUserData;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final MutableLiveData<List<BaseUserData>> baseUserListMutableLiveData = new MutableLiveData<>();
    CompositeDisposable disposable;
    @Inject
    MainRepository mainRepository;

    @Inject
    public MainViewModel() {
        disposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }

    public MutableLiveData<List<BaseUserData>> getBaseUserListMutableLiveData() {
        return baseUserListMutableLiveData;
    }

    public void getUserDetailsFromWeb() {
        mainRepository.getUserDataFromWeb(baseUserListMutableLiveData, disposable);
    }
}
