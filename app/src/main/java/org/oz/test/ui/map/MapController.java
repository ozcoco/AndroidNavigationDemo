package org.oz.test.ui.map;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import org.oz.test.base.controller.BaseController;

public class MapController extends BaseController<MapFragment> implements MapContract.View {


    MapController(@NonNull MapFragment fragment) {
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
