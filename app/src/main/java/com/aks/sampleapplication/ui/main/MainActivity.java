package com.aks.sampleapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aks.sampleapplication.data.BaseUserData;
import com.aks.sampleapplication.databinding.ActivityMainBinding;
import com.aks.sampleapplication.ui.second.SecondMainActivity;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    ActivityMainBinding mainBinding;
    MainRvAdapter mainRvAdapter;
    private List<BaseUserData> userDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainBinding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        mainRvAdapter = new MainRvAdapter(getBaseContext(), (MainRvAdapter.RvInterface) position -> {
            Intent intent = new Intent(getBaseContext(), SecondMainActivity.class);
            intent.putExtra("personId", userDataList.get(position).getId());
            startActivity(intent);
        }, userDataList);
        mainBinding.rvMain.setAdapter(mainRvAdapter);
        mainViewModel.getUserDetailsFromWeb();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.getBaseUserListMutableLiveData().observe(this, baseUserData -> {
            userDataList = baseUserData;
            mainRvAdapter.updateData(userDataList);
            mainRvAdapter.notifyDataSetChanged();
        });
    }
}