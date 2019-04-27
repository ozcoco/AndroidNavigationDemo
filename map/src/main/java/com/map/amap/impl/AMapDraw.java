package com.map.amap.impl;

import android.content.Context;

import com.amap.api.maps.model.LatLng;
import com.map.amap.helper.AMapHelper;
import com.map.amap.utils.LatlngUtils;
import com.map.entity.MyLatLng;
import com.map.feature.IMapDraw;

import java.util.List;

public class AMapDraw implements IMapDraw {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    public AMapDraw(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }


    @Override
    public void drawMarker(MyLatLng latLng, int resId, String title, String snippet) {

        final LatLng lng = LatlngUtils.toAMap(latLng);

        AMapHelper helper = AMapHelper.newInstance(mContext, mAMap);

        helper.drawMarker(lng, resId, title, snippet);
    }

    @Override
    public void drawMarker(MyLatLng latLng, int resId) {

        drawMarker(latLng, resId, null, null);

    }

    @Override
    public void drawMarker(MyLatLng latLng) {

        drawMarker(latLng, 0);
    }


    @Override
    public void drawTrack(List<MyLatLng> latLngs, int resId) {

        List<LatLng> lngs = LatlngUtils.toAMap(latLngs);

        AMapHelper helper = AMapHelper.newInstance(mContext, mAMap);

        helper.drawTrack(lngs, resId);

    }

    @Override
    public void drawTrack(List<MyLatLng> latLngs) {

        drawTrack(latLngs, 0);

    }

    @Override
    public void drawSmoothTrack(List<MyLatLng> latLngs, int resId) {

        List<LatLng> lngs = LatlngUtils.toAMap(latLngs);

        AMapHelper helper = AMapHelper.newInstance(mContext, mAMap);

        helper.drawSmoothTrack(lngs, resId);

    }

    @Override
    public void drawSmoothTrack(List<MyLatLng> latLngs) {

        drawSmoothTrack(latLngs, 0);
    }
}
