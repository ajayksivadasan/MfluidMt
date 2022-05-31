package com.aks.sampleapplication.utils;

import android.content.Context;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class BaseUtilsClass {
    Context context;

    @Inject
    public BaseUtilsClass(@ApplicationContext Context context) {
        this.context = context;
    }
}
