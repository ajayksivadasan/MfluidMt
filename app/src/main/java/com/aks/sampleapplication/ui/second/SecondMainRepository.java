package com.aks.sampleapplication.ui.second;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.aks.sampleapplication.data.MessageDetails;
import com.aks.sampleapplication.data.ReceiveMessage;
import com.aks.sampleapplication.di.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SecondMainRepository {
    ApiInterface apiInterface;

    @Inject
    public SecondMainRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void getChatList(int personId, MutableLiveData<List<MessageDetails>> messageDetailsLiveData, CompositeDisposable disposable) {
        Observable<ReceiveMessage> observable = apiInterface.getMessageDetails(String.valueOf(personId));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReceiveMessage>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(ReceiveMessage receiveMessage) {
                        messageDetailsLiveData.postValue(receiveMessage.getMessages());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("cp", "cp");
                    }
                });
    }
}
