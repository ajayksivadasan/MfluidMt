package com.aks.sampleapplication.ui.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.aks.sampleapplication.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SecondMainActivity extends AppCompatActivity {
    SecondMainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        viewModel=new ViewModelProvider(this).get(SecondMainViewModel.class);
    }
}