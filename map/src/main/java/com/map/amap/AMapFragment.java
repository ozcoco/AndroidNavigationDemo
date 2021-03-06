package com.map.amap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amap.api.maps.MapView;
import com.map.R;
import com.map.base.BaseFragment;
import com.map.impl.AMap;

public class AMapFragment extends BaseFragment {


    private MapView mMapView;


    public static AMapFragment newInstance() {
        return new AMapFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_amap, container, false);

        mMapView = root.findViewById(R.id.map_view);

        mMapView.onCreate(savedInstanceState);

        com.amap.api.maps.AMap map = mMapView.getMap();

        map.setMapType(com.amap.api.maps.AMap.MAP_TYPE_SATELLITE);

        setMap(new AMap(getContext(), map));

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMap();

        initData();

        initView();
    }

    private void initMap() {


    }

    private void initView() {


    }


    private void initData() {


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
    public void onStart() {
        super.onStart();
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
    public void onDestroy() {
        super.onDestroy();

        mMapView.onDestroy();
    }

}
