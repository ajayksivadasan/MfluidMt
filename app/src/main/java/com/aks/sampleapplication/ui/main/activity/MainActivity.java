package com.aks.sampleapplication.ui.main.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aks.sampleapplication.R;
import com.aks.sampleapplication.data.BaseUserData;
import com.aks.sampleapplication.ui.main.view_model.MainViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getUserDetailsFromWeb();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.getBaseUserListMutableLiveData().observe(this, new Observer<List<BaseUserData>>() {
            @Override
            public void onChanged(List<BaseUserData> baseUserData) {

            }
        });
    }
}