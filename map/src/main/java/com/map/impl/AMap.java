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

    private IMapSearch mapSearch;

    @Override
    public IMapSearch getMapSearch() {
        return mapSearch == null ? mapSearch = new AMapSearch(mContext, mAMap) : mapSearch;
    }

    private IMapDraw mapDraw;

    @Override
    public IMapDraw getMapDraw() {
        return mapDraw == null ? mapDraw = new AMapDraw(mContext, mAMap) : mapDraw;
    }

    private IMapStyle mapStyle;

    @Override
    public IMapStyle getMapStyle() {
        return mapStyle == null ? mapStyle = new AMapStyle(mContext, mAMap) : mapStyle;
    }

    private IMapLocation mapLocation;

    @Override
    public IMapLocation getMapLocation() {
        return mapLocation == null ? mapLocation = new AMapLocation(mContext, mAMap) : mapLocation;
    }
}
