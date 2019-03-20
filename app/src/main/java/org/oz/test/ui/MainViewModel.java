package org.oz.test.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel implements MainContract.Model {

    @Override
    public void print() {

        Log.i("----> ^_*", "print >>>>>>>>");

    }


    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
