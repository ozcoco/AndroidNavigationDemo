package com.map.amap.helper;

import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.map.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;


public class AMapHelper {

    static {

        Logger.addLogAdapter(new AndroidLogAdapter());

    }


    private AMap mAMap;

    private Context mContext;

    public AMapHelper(AMap map) {

        mAMap = map;

    }

    public AMapHelper(Context context, AMap map) {

        mContext = context;

        mAMap = map;

    }

    public static AMapHelper newInstance(Context context, AMap map) {

        return new AMapHelper(context, map);
    }


    private void showMyLocation() {

        AMapLocationClient mapLocationClient = new AMapLocationClient(mContext);

        AMapLocationClientOption locationOption = null;

        //初始化定位参数
        locationOption = new AMapLocationClientOption();
//设置返回地址信息，默认为true
        locationOption.setNeedAddress(true);
//设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//设置定位间隔,单位毫秒,默认为2000ms
        locationOption.setInterval(2000);
//设置定位参数
        mapLocationClient.setLocationOption(locationOption);

        mapLocationClient.setLocationListener(location -> {

            if (location != null) {
                if (location.getErrorCode() == 0) {

                    drawMyLocation(new LatLng(location.getLatitude(), location.getLongitude()));

                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。

                    Logger.d("AMapError,location Error, ErrCode: %d , errInfo: %d", location.getErrorCode(), location.getErrorInfo());
                }
            }


        });

        mapLocationClient.startLocation();

    }


    public void drawMyLocation(LatLng latLng) {

        drawMarker(latLng, R.drawable.ic_marker_red);

    }


    public void drawMarker(LatLng latLng) {

        drawMarker(latLng, 0, null, null);

    }

    public void drawMarker(LatLng latLng, int drawableId) {

        drawMarker(latLng, drawableId, null, null);

    }

    public void drawMarker(LatLng latLng, int drawableId, String title, String snippet) {

        if (mAMap == null) return;

        mAMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(drawableId <= 0 ? R.drawable.ic_marker_red : drawableId)).title(title).snippet(snippet));

        LatLngBounds.Builder bounds = new LatLngBounds.Builder();

        bounds.include(latLng);

        mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100));//第二个参数为四周留空宽度

    }


    public void drawTrack(List<LatLng> latLngs) {

        drawTrack(latLngs, 0);
    }

    public void drawTrack(List<LatLng> latLngs, int drawableId) {

        if (mAMap == null || latLngs == null) return;


        if (latLngs.size() == 0) {

            showMyLocation();

            return;
        }

        PathSmoothTool pathSmoothTool = new PathSmoothTool();
        //设置平滑处理的等级
        pathSmoothTool.setIntensity(0);

        LatLngBounds.Builder bounds = new LatLngBounds.Builder();

        mAMap.addMarker(new MarkerOptions().position(latLngs.get(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.start)).title("Start").snippet("Start Point"));

        mAMap.addMarker(new MarkerOptions().position(latLngs.get(latLngs.size() - 1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.end)).title("End").snippet("End Point"));

        for (LatLng point : latLngs)
            bounds.include(point);

        mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100));//第二个参数为四周留空宽度

        mAMap.addPolyline(new PolylineOptions().
                addAll(latLngs).width(30).setUseTexture(true).setCustomTexture(BitmapDescriptorFactory.fromResource(drawableId <= 0 ? R.drawable.tracelinetexture : drawableId)));

    }


    public void drawSmoothTrack(List<LatLng> latLngs) {

        drawSmoothTrack(latLngs, 0);
    }


    public void drawSmoothTrack(List<LatLng> latLngs, int drawableId) {

        if (mAMap == null || latLngs == null) return;


        if (latLngs.size() == 0) {

            showMyLocation();

            return;
        }

        PathSmoothTool pathSmoothTool = new PathSmoothTool();
        //设置平滑处理的等级
        pathSmoothTool.setIntensity(0);

        List<LatLng> points = pathSmoothTool.pathOptimize(latLngs);

        if (points == null && points.size() == 0) return;

        LatLngBounds.Builder bounds = new LatLngBounds.Builder();

        mAMap.addMarker(new MarkerOptions().position(points.get(0)).icon(BitmapDescriptorFactory.fromResource(R.drawable.start)).title("Start").snippet("Start Point"));

        mAMap.addMarker(new MarkerOptions().position(points.get(points.size() - 1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.end)).title("End").snippet("End Point"));

        for (LatLng point : points)
            bounds.include(point);

        mAMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100));//第二个参数为四周留空宽度

        mAMap.addPolyline(new PolylineOptions().
                addAll(points).width(30).setUseTexture(true).setCustomTexture(BitmapDescriptorFactory.fromResource(drawableId <= 0 ? R.drawable.tracelinetexture : drawableId)));

    }


}
