package com.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.map.amap.AMapView;
import com.map.base.BaseMapView;

public class MapFragment extends Fragment {

    private Map mMap;

    private Platform mPlatform;

    private BaseMapView mMapView;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(Platform platform) {
        return new MapFragment(platform);
    }

    public Map getMap() {
        return mMap;
    }

    public MapFragment() {
        this(Platform.AMAP);
    }

    public MapFragment(Platform platform) {

        this.mPlatform = platform;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final FrameLayout root = (FrameLayout) inflater.inflate(R.layout.fragment_map, container, false);

        initMapFragment(root, savedInstanceState);

        return root;
    }


    private void initMapFragment(FrameLayout layout, Bundle savedInstanceState) {

        assert layout != null;

        switch (mPlatform) {

            case BMAP:

                mMapView = new AMapView(layout.getContext());

                break;

            case AMAP:

                mMapView = new AMapView(layout.getContext());

                break;
        }

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        layout.addView(mMapView, layoutParams);

        mMap = new Map(mMapView.getMap());

        mMapView.onCreate(savedInstanceState);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();

        mMapView.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();

        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mMapView.onDestroy();

    }

}
