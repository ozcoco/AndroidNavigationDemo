package com.map.amap.impl;

import android.content.Context;
import android.graphics.Point;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.map.R;
import com.map.amap.utils.ToUtils;
import com.map.constant.MapResult;
import com.map.entity.Location;
import com.map.feature.IMapLocation;
import com.map.feature.OnLocationChangeListener;
import com.map.feature.OnPinPointListener;
import com.orhanobut.logger.Logger;

public class AMapLocation implements IMapLocation, LocationSource, AMapLocationListener {

    private final Context mContext;

    private final com.amap.api.maps.AMap mAMap;

    private OnLocationChangedListener mListener;

    private AMapLocationClient mLocationClient;

    private AMapLocationClientOption mLocationOption;

    private OnPinPointListener mOnPinPointListener;

    public AMapLocation(Context context, com.amap.api.maps.AMap aMap) {

        this.mContext = context;

        this.mAMap = aMap;
    }


    @Override
    public void setOnPinPointListener(OnPinPointListener listener) {

        mOnPinPointListener = listener;

    }

    @Override
    public void showMyLocation() {

        assert mAMap != null;

        mAMap.setLocationSource(this);// 设置定位监听

        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。

        mAMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style

        mAMap.getUiSettings().setMyLocationButtonEnabled(true); //设置默认定位按钮是否显示，非必需设置。

        mAMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);

        myLocationStyle.showMyLocation(true);

    }


    @Override
    public void setOnMyLocationChangeListener(OnLocationChangeListener listener) {

        assert mAMap != null && listener != null;

        mAMap.setOnMyLocationChangeListener(location -> {

            final Location bean = ToUtils.to(location);

            listener.onLocationChange(bean);

        });

    }


    private LatLonPoint pinPoint;

    @Override
    public void setPinCenterControlsEnabled(boolean enabled) {

        assert mAMap != null;

        if (!enabled) return;

        mAMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {

                pinPoint = new LatLonPoint(cameraPosition.target.latitude, cameraPosition.target.longitude);

                if (mOnPinPointListener != null)
                    mOnPinPointListener.onPinPoint(ToUtils.to(pinPoint), MapResult.Success);

            }
        });

        mAMap.setOnMapLoadedListener(this::addMarkerInScreenCenter);

    }

    private void addMarkerInScreenCenter() {

        assert mAMap != null;

        LatLng latLng = mAMap.getCameraPosition().target;

        Point screenPosition = mAMap.getProjection().toScreenLocation(latLng);

        Marker pickCenterMarker = mAMap.addMarker(new MarkerOptions()
                .anchor(0.5f, 0.5f)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_purple_pin)));
        //设置Marker在屏幕上,不跟随地图移动
        pickCenterMarker.setPositionByPixels(screenPosition.x, screenPosition.y);

        pickCenterMarker.setZIndex(1);

    }


    @Override
    public void activate(OnLocationChangedListener listener) {

        mListener = listener;

        if (mLocationClient == null) {

            mLocationClient = new AMapLocationClient(mContext);

            mLocationOption = new AMapLocationClientOption();
            //设置定位监听
            mLocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setOnceLocation(true);
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mLocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mLocationClient.startLocation();
        }

    }

    @Override
    public void deactivate() {

        mListener = null;
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
        mLocationClient = null;

    }

    @Override
    public void onLocationChanged(com.amap.api.location.AMapLocation location) {

        assert mAMap != null;

        if (mListener != null && location != null) {

            if (location.getErrorCode() == 0) {

                mListener.onLocationChanged(location);

                LatLng curLatlng = new LatLng(location.getLatitude(), location.getLongitude());

                pinPoint = new LatLonPoint(curLatlng.latitude, curLatlng.longitude);

                mAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(curLatlng, 16f));


            } else {
                String errText = "定位失败," + location.getErrorCode() + ": " + location.getErrorInfo();

                Logger.e("AmapErr", errText);
            }
        }

    }


}
