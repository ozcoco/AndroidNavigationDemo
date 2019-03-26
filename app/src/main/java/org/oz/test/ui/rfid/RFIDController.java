package org.oz.test.ui.rfid;

import org.oz.test.base.controller.BaseController;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class RFIDController extends BaseController<RFIDFragment> implements RFIDContract.View {


    RFIDController(@NonNull RFIDFragment fragment) {
        super(fragment);
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        super.onAny(owner, event);
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
