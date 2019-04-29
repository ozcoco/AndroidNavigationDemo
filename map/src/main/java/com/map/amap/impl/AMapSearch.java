package com.map.amap.impl;

import android.content.Context;

import com.map.feature.IMapSearch;

public class AMapSearch implements IMapSearch {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapSearch(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }



}
