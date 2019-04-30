package com.map.feature;

import com.map.constant.MapResult;
import com.map.entity.Address;

public interface OnRegeocodeSearchListener {

    void onRegeocodeSearch(Address data, MapResult result);
}
