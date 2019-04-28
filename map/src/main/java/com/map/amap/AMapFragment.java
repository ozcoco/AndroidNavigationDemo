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

import java.util.Objects;

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

        setMap(new AMap(mMapView.getContext(), mMapView.getMap()));

        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMapView.onCreate(savedInstanceState);

        initData();

        initView();
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
