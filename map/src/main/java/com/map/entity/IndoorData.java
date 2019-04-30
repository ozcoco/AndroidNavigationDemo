package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class IndoorData implements Parcelable, Serializable, Cloneable {

    private String poiId;

    private int floor;

    private String floorName;

    public IndoorData() {
    }

    public IndoorData(String poiId, int floor, String floorName) {
        this.poiId = poiId;
        this.floor = floor;
        this.floorName = floorName;
    }

    protected IndoorData(Parcel in) {
        poiId = in.readString();
        floor = in.readInt();
        floorName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poiId);
        dest.writeInt(floor);
        dest.writeString(floorName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IndoorData> CREATOR = new Creator<IndoorData>() {
        @Override
        public IndoorData createFromParcel(Parcel in) {
            return new IndoorData(in);
        }

        @Override
        public IndoorData[] newArray(int size) {
            return new IndoorData[size];
        }
    };

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
}
