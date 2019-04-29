package com.map.base;

import android.content.Context;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.map.ILifeCycle;
import com.map.IMap;

public abstract class BaseMapView extends FrameLayout implements ILifeCycle {

    private IMap mMap;

    public IMap getMap() {

        return mMap;
    }

    protected void setMap(IMap map) {
        mMap = map;
    }

    public BaseMapView(@NonNull Context context) {

        super(context);

    }

}
