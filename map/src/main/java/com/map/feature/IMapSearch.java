package com.map.feature;

import com.map.constant.PoiSearchType;
import com.map.entity.LatLngPoint;

public interface IMapSearch {

    void setOnRegeocodeSearchListener(OnRegeocodeSearchListener listener);

    void setOnPoiSearchListener(OnPoiSearchListener listener);

    void geocodeSearch(LatLngPoint point);

    void geocodeSearch(LatLngPoint point, int radius);

    void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point);

    void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point, int page);

    void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point, int radius, int page);

    void keyTips(String key, OnKeyTipsListener listener);

    void keyTips(String key, String city, OnKeyTipsListener listener);

}
