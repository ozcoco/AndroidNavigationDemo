package com.map.base;

import androidx.fragment.app.Fragment;

import com.map.IMap;

public abstract class BaseFragment extends Fragment {

    private IMap mMap;

    public IMap getMap() {

        return mMap;
    }

    protected void setMap(IMap map) {
        mMap = map;
    }


}
