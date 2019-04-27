package com.map.amap.utils;

import com.amap.api.maps.model.LatLng;
import com.map.entity.MyLatLng;

import java.util.ArrayList;
import java.util.List;

public final class LatlngUtils {

    public static LatLng toAMap(MyLatLng latLng) {

        assert latLng != null;

        return new LatLng(latLng.latitude, latLng.longitude);
    }

    public static List<LatLng> toAMap(List<MyLatLng> latLngs) {

        assert latLngs != null;

        List<LatLng> list = new ArrayList<>();

        int len = latLngs.size();

        for (int i = 0; i < len; i++)
            list.add(new LatLng(latLngs.get(i).latitude, latLngs.get(i).longitude));

        return list;
    }


}
