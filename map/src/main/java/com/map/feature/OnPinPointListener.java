package com.map.feature;

import com.map.constant.MapResult;
import com.map.entity.LatLngPoint;

public interface OnPinPointListener {

    void onPinPoint(LatLngPoint point, MapResult result);
}
