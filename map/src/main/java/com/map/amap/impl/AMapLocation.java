package com.map.amap.impl;

import android.content.Context;

import com.map.feature.IMapLocation;

public class AMapLocation implements IMapLocation {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapLocation(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }


}
