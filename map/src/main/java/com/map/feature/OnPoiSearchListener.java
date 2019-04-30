package com.map.feature;

import com.map.constant.MapResult;
import com.map.entity.PoiItem;

import java.util.List;

public interface OnPoiSearchListener {

    void onPoiItems(List<PoiItem> data, MapResult result);
}
