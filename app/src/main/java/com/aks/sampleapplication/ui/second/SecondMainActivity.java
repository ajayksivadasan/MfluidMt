package com.aks.sampleapplication.ui.second;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.aks.sampleapplication.data.MessageDetails;
import com.aks.sampleapplication.databinding.ActivitySecondMainBinding;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SecondMainActivity extends AppCompatActivity {
    ActivitySecondMainBinding mainBinding;
    SecondMainViewModel viewModel;
    RvSecondAdapter rvSecondAdapter;
    List<MessageDetails> messageDetailsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivitySecondMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        Intent intent = getIntent();
        viewModel = new ViewModelProvider(this).get(SecondMainViewModel.class);
        if (intent != null) {
            rvSecondAdapter = new RvSecondAdapter(getBaseContext(), messageDetailsList, intent.getExtras().getString("avatar", ""));
            mainBinding.rvSecond.setAdapter(rvSecondAdapter);
            viewModel.getChatList(intent.getExtras().getInt("personId"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getMessageDetailsLiveData().observe(this, messageDetails -> {
            this.messageDetailsList = messageDetails;
            rvSecondAdapter.updateAdapter(messageDetails);
            rvSecondAdapter.notifyDataSetChanged();
        });
    }
}