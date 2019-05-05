package com.map.bmap.impl;

import com.map.constant.PoiSearchType;
import com.map.entity.LatLngPoint;
import com.map.feature.IMapSearch;
import com.map.feature.OnKeyTipsListener;
import com.map.feature.OnPoiSearchListener;
import com.map.feature.OnRegeocodeSearchListener;

public class BMapSearch implements IMapSearch {
    @Override
    public void setOnRegeocodeSearchListener(OnRegeocodeSearchListener listener) {

    }

    @Override
    public void setOnPoiSearchListener(OnPoiSearchListener listener) {

    }

    @Override
    public void geocodeSearch(LatLngPoint point) {

    }

    @Override
    public void geocodeSearch(LatLngPoint point, int radius) {

    }

    @Override
    public void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point) {

    }

    @Override
    public void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point, int page) {

    }

    @Override
    public void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point, int radius, int page) {

    }

    @Override
    public void keyTips(String key, OnKeyTipsListener listener) {

    }

    @Override
    public void keyTips(String key, String city, OnKeyTipsListener listener) {

    }
}
