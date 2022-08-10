package com.aks.sampleapplication.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.aks.sampleapplication.data.BaseUserData;
import com.aks.sampleapplication.di.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {
    ApiInterface apiInterface;

    @Inject
    public MainRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void getUserDataFromWeb(MutableLiveData<List<BaseUserData>> baseUserListMutableLiveData, CompositeDisposable disposable) {
        Observable<List<BaseUserData>> observable = apiInterface.getUsersList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BaseUserData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<BaseUserData> baseUserData) {
                        baseUserListMutableLiveData.postValue(baseUserData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("onCompleteUser", "completed");
                    }
                });

    }
}
