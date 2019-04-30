package com.map.amap.impl;

import android.content.Context;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.map.amap.utils.ToUtils;
import com.map.constant.MapResult;
import com.map.entity.Address;
import com.map.entity.LatLngPoint;
import com.map.entity.Tip;
import com.map.feature.IMapSearch;
import com.map.feature.OnKeyTipsListener;
import com.map.constant.PoiSearchType;
import com.map.feature.OnPoiSearchListener;
import com.map.feature.OnRegeocodeSearchListener;

import java.util.ArrayList;
import java.util.List;

public class AMapSearch implements IMapSearch, GeocodeSearch.OnGeocodeSearchListener, PoiSearch.OnPoiSearchListener {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    private GeocodeSearch mGeocodeSearch;

    private OnRegeocodeSearchListener mOnRegeocodeSearchListener;

    private OnPoiSearchListener mOnPoiSearchListener;

    public AMapSearch(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }

    private void initGeocodeSearch() {

        assert mContext != null;

        if (mGeocodeSearch != null) return;

        mGeocodeSearch = new GeocodeSearch(mContext);

        mGeocodeSearch.setOnGeocodeSearchListener(this);

    }

    @Override
    public void setOnRegeocodeSearchListener(OnRegeocodeSearchListener listener) {

        mOnRegeocodeSearchListener = listener;

    }

    @Override
    public void setOnPoiSearchListener(OnPoiSearchListener listener) {

        mOnPoiSearchListener = listener;

    }

    @Override
    public void geocodeSearch(LatLngPoint point) {

        geocodeSearch(point, 200);

    }

    @Override
    public void geocodeSearch(LatLngPoint point, int radius) {

        assert point != null;

        initGeocodeSearch();

        com.amap.api.services.core.LatLonPoint searchLatLonPoint = new LatLonPoint(point.getLatitude(), point.getLongitude());

        RegeocodeQuery query = new RegeocodeQuery(searchLatLonPoint, radius, GeocodeSearch.AMAP);// 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系

        mGeocodeSearch.getFromLocationAsyn(query);

    }

    @Override
    public void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point) {

        poiSearch(key, searchType, searchRegion, point, 0);

    }

    @Override
    public void poiSearch(String key, PoiSearchType searchType, String searchRegion, LatLngPoint point, int page) {

        poiSearch(key, searchType, searchRegion, point, 1000, page);
    }

    @Override
    public void poiSearch(String searchKey, PoiSearchType searchType, String city, LatLngPoint point, int radius, int page) {

        assert mContext != null;

        PoiSearch.Query query = new PoiSearch.Query(searchKey, searchType.key, city);// 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）

        query.setCityLimit(true);

        query.setPageSize(20);

        query.setPageNum(page);

        com.amap.api.services.core.LatLonPoint searchLatLonPoint = new LatLonPoint(point.getLatitude(), point.getLongitude());

        PoiSearch poiSearch = new PoiSearch(mContext, query);

        poiSearch.setOnPoiSearchListener(this);

        poiSearch.setBound(new PoiSearch.SearchBound(searchLatLonPoint, radius, true));

        poiSearch.searchPOIAsyn();

    }

    @Override
    public void keyTips(String key, OnKeyTipsListener listener) {

        keyTips(key, "", listener);
    }

    @Override
    public void keyTips(String key, String city, OnKeyTipsListener listener) {

        assert mContext != null && listener != null;

        InputtipsQuery query = new InputtipsQuery(key, city);

        Inputtips inputTips = new Inputtips(mContext, query);

        query.setCityLimit(true);

        inputTips.setInputtipsListener((data, rCode) -> {

            if (rCode == AMapException.CODE_AMAP_SUCCESS) {// 正确返回

                final List<Tip> list = new ArrayList<>();

                int len = data.size();

                for (int i = 0; i < len; i++) {

                    list.add(ToUtils.toMy(data.get(i)));
                }

                listener.onKeyTips(list, MapResult.Success);
            } else {

                listener.onKeyTips(null, MapResult.Fail);
            }

        });

        inputTips.requestInputtipsAsyn();
    }


    /*************************geocode*******************************/

    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {

        if (rCode == AMapException.CODE_AMAP_SUCCESS) {

            if (result != null && result.getRegeocodeAddress() != null
                    && result.getRegeocodeAddress().getFormatAddress() != null) {

                final Address address = ToUtils.to(result.getRegeocodeAddress());

                address.setPoint(ToUtils.to(result.getRegeocodeQuery().getPoint()));

            }
        }


    }

    @Override
    public void onGeocodeSearched(GeocodeResult result, int rCode) {


    }

    /*************************POI*******************************/

    @Override
    public void onPoiSearched(PoiResult result, int rCode) {

        if (rCode == AMapException.CODE_AMAP_SUCCESS) {

            ArrayList<PoiItem> pois = result.getPois();

        }
    }

    @Override
    public void onPoiItemSearched(PoiItem item, int rCode) {


    }


}
