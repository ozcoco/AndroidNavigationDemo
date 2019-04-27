package com.map;

import com.map.feature.IMapDraw;
import com.map.feature.IMapLocation;
import com.map.feature.IMapSearch;
import com.map.feature.IMapStyle;

public class Map implements IMap {

    private final IMap mMap;

    public Map(IMap map) {
        mMap = map;
    }


    @Override
    public IMapSearch getMapSearch() {
        return mMap.getMapSearch();
    }

    @Override
    public IMapDraw getMapDraw() {
        return mMap.getMapDraw();
    }

    @Override
    public IMapStyle getMapStyle() {
        return mMap.getMapStyle();
    }

    @Override
    public IMapLocation getMapLocation() {
        return mMap.getMapLocation();
    }
}
