package com.map.amap.impl;

import android.content.Context;

import com.amap.api.maps.AMap;
import com.map.feature.IMapStyle;
import com.map.constant.MapType;

public class AMapStyle implements IMapStyle {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapStyle(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }


    @Override
    public void setMapType(MapType type) {

        assert mAMap != null;

        switch (type) {
            case MAP_TYPE_NAVI:
                mAMap.setMapType(AMap.MAP_TYPE_NAVI);
                break;
            case MAP_TYPE_BUS:
                mAMap.setMapType(AMap.MAP_TYPE_BUS);
                break;
            case MAP_TYPE_NIGHT:
                mAMap.setMapType(AMap.MAP_TYPE_NIGHT);
                break;
            case MAP_TYPE_NORMAL:
                mAMap.setMapType(AMap.MAP_TYPE_NORMAL);
                break;
            case MAP_TYPE_SATELLITE:
                mAMap.setMapType(AMap.MAP_TYPE_SATELLITE);
                break;
        }

    }

    @Override
    public void setZoomControlsEnabled(boolean enabled) {

        assert mAMap != null;

        mAMap.getUiSettings().setZoomControlsEnabled(enabled);


    }
}
