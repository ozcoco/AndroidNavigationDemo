package com.map.amap;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.amap.api.maps.MapView;
import com.map.base.BaseMapView;
import com.map.impl.AMap;

public class AMapView extends BaseMapView {

    private final MapView mMapView;

    public AMapView(@NonNull Context context) {
        super(context);

        mMapView = new MapView(context);

        FrameLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        addView(mMapView, layoutParams);

        com.amap.api.maps.AMap map = mMapView.getMap();

        setMap(new AMap(getContext(), map));

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        mMapView.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {

        mMapView.onResume();

    }

    @Override
    public void onPause() {

        mMapView.onPause();

    }

    @Override
    public void onDestroy() {

        mMapView.onDestroy();

    }
}
