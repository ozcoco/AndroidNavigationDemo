package org.oz.test.ui.rfid;

import android.app.Application;

import org.oz.uhf.IUHFService;
import org.oz.uhf.UHFService;
import org.oz.uhf.base.ScanControl;
import org.oz.uhf.emtity.Tag;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RfidViewModel extends AndroidViewModel implements RFIDContract.Model {

    public final MutableLiveData<Integer> count;

    public final MutableLiveData<String> tags;


    private ScanControl scanControl;

    @Override
    public void scan() {

        if (scanControl == null)
            scanControl = UHFService.getInstance().multiScan(IUHFService.SCAN_TYPE.TID, data -> {

                // running into work thread
                final StringBuilder builder = new StringBuilder(Objects.requireNonNull(tags.getValue()));

                for (Tag tag : data)
                    builder.append("\n\n\t\t").append(tag.getData());

                tags.postValue(builder.toString());

            });
        else if (scanControl.isScan()) {

            scanControl.stop();

            scanControl = null;
        }


    }


    public RfidViewModel(@NonNull Application application) {
        super(application);

        //init uhf
        UHFService.getInstance().init(null);

        count = new MutableLiveData<>(0);

        tags = new MutableLiveData<>("");
    }


    @Override
    protected void onCleared() {
        super.onCleared();

        UHFService.getInstance().onCleared();
    }


}
