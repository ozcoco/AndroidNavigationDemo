package com.map;

import com.map.feature.IMapDraw;
import com.map.feature.IMapLocation;
import com.map.feature.IMapSearch;
import com.map.feature.IMapStyle;

public interface IMap {

    IMapSearch getMapSearch();

    IMapDraw getMapDraw();

    IMapStyle getMapStyle();

    IMapLocation getMapLocation();

}
