package com.map.feature;

import com.map.entity.MyLatLng;

import java.util.List;

public interface IMapDraw {

    void drawMarker(MyLatLng latLng, int resId, String title, String snippet);

    void drawMarker(MyLatLng latLng, int resId);

    void drawMarker(MyLatLng latLng);

    void drawTrack(List<MyLatLng> latLngs, int resId);

    void drawTrack(List<MyLatLng> latLngs);

    void drawSmoothTrack(List<MyLatLng> latLngs, int resId);

    void drawSmoothTrack(List<MyLatLng> latLngs);

}
