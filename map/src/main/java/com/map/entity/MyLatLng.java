package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class MyLatLng implements Parcelable, Cloneable {

    public final double latitude;
    public final double longitude;

    public MyLatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public MyLatLng clone() {
        return new MyLatLng(this.latitude, this.longitude);
    }

    protected MyLatLng(Parcel in) {
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

    public static final Creator<MyLatLng> CREATOR = new Creator<MyLatLng>() {
        @Override
        public MyLatLng createFromParcel(Parcel in) {
            return new MyLatLng(in);
        }

        @Override
        public MyLatLng[] newArray(int size) {
            return new MyLatLng[size];
        }
    };
}
