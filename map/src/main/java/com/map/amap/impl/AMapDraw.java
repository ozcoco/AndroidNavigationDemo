package com.map.amap.impl;

import android.content.Context;

import com.map.feature.IMapDraw;

public class AMapDraw implements IMapDraw {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapDraw(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }

}
