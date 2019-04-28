package com.map.impl;

import android.content.Context;

import com.map.IMap;
import com.map.amap.impl.AMapDraw;
import com.map.amap.impl.AMapLocation;
import com.map.amap.impl.AMapSearch;
import com.map.amap.impl.AMapStyle;
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
        return new AMapSearch(mContext, mAMap);
    }

    @Override
    public IMapDraw getMapDraw() {
        return new AMapDraw(mContext, mAMap);
    }

    @Override
    public IMapStyle getMapStyle() {
        return new AMapStyle(mContext, mAMap);
    }

    @Override
    public IMapLocation getMapLocation() {
        return new AMapLocation(mContext, mAMap);
    }
}
