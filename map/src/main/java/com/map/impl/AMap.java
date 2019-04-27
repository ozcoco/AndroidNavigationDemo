package com.map.impl;

import android.content.Context;

import com.map.IMap;
import com.map.feature.IMapDraw;
import com.map.feature.IMapLocation;
import com.map.feature.IMapSearch;
import com.map.feature.IMapStyle;

public class AMap implements IMap {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMap(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }

    @Override
    public IMapSearch getMapSearch() {
        return null;
    }

    @Override
    public IMapDraw getMapDraw() {
        return null;
    }

    @Override
    public IMapStyle getMapStyle() {
        return null;
    }

    @Override
    public IMapLocation getMapLocation() {
        return null;
    }
}
