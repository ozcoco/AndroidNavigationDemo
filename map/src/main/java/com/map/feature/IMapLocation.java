package com.map.feature;

public interface IMapLocation {

    void showMyLocation();

    void setOnMyLocationChangeListener(OnLocationChangeListener listener);

    void setPinCenterControlsEnabled(boolean enabled);

}
