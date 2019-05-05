package com.map.feature;

public interface IMapLocation {

    void setOnPinPointListener(OnPinPointListener listener);

    void showMyLocation();

    void setOnMyLocationChangeListener(OnLocationChangeListener listener);

    void setPinCenterControlsEnabled(boolean enabled);

}
