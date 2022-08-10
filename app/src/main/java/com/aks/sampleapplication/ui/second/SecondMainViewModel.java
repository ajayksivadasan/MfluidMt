package com.aks.sampleapplication.ui.second;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aks.sampleapplication.data.MessageDetails;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class SecondMainViewModel extends ViewModel {
    private final MutableLiveData<List<MessageDetails>> messageDetailsLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposable = new CompositeDisposable();
    @Inject
    SecondMainRepository secondMainRepository;

    @Inject
    public SecondMainViewModel() {
    }

    public MutableLiveData<List<MessageDetails>> getMessageDetailsLiveData() {
        return messageDetailsLiveData;
    }

    public void getChatList(String personId) {
        secondMainRepository.getChatList(personId, messageDetailsLiveData, disposable);
    }
}
