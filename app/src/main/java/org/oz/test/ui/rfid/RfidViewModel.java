package org.oz.test.ui.rfid;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RfidViewModel extends AndroidViewModel {

    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public RfidViewModel(@NonNull Application application) {
        super(application);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
