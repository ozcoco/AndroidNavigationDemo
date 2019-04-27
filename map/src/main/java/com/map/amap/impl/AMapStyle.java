package com.map.amap.impl;

import android.content.Context;

import com.map.feature.IMapStyle;

public class AMapStyle implements IMapStyle {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapStyle(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }


}
