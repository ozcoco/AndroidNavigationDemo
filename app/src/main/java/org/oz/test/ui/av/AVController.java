package org.oz.test.ui.av;

import org.oz.test.base.controller.BaseController;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class AVController extends BaseController<AVFragment> implements AVContract.View {


    AVController(@NonNull AVFragment fragment) {
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
