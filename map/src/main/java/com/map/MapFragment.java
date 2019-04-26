package com.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.map.amap.AMapFragment;
import com.map.base.BaseFragment;
import com.map.bmap.BMapFragment;

public class MapFragment extends Fragment {

    public enum Platform {
        BMAP, // 百度
        AMAP //高德
    }

    private Map mMap;

    private Platform mPlatform;


    public Map getMap() {
        return mMap;
    }

    public MapFragment(Platform platform) {

        this.mPlatform = platform;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_map, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initMapFragment();
    }


    private void initMapFragment() {

        BaseFragment fragment = null;

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if (mPlatform == Platform.AMAP) {

            fragment = AMapFragment.newInstance();

            transaction.replace(R.id.container, fragment);

            mMap = new Map(fragment.getMap());

        } else if (mPlatform == Platform.BMAP) {

            fragment = BMapFragment.newInstance();

            transaction.replace(R.id.container, fragment);

        }

        transaction.commit();

        if (fragment != null)
            mMap = new Map(fragment.getMap());

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }
}
