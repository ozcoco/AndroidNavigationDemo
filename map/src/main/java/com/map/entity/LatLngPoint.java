package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class LatLngPoint implements Parcelable, Serializable, Cloneable {

    private final double latitude;
    private final double longitude;

    public LatLngPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    protected LatLngPoint(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LatLngPoint> CREATOR = new Creator<LatLngPoint>() {
        @Override
        public LatLngPoint createFromParcel(Parcel in) {
            return new LatLngPoint(in);
        }

        @Override
        public LatLngPoint[] newArray(int size) {
            return new LatLngPoint[size];
        }
    };
}
