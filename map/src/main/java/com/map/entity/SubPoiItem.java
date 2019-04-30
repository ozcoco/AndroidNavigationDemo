package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class SubPoiItem implements Parcelable, Serializable, Cloneable {

    private String poiId;

    private String title;

    private String subName;

    private int distance;

    private LatLngPoint point;

    private String snippet;

    private String subTypeDes;


    public SubPoiItem() {
    }

    public SubPoiItem(String poiId, String title, String subName, int distance, LatLngPoint point, String snippet, String subTypeDes) {
        this.poiId = poiId;
        this.title = title;
        this.subName = subName;
        this.distance = distance;
        this.point = point;
        this.snippet = snippet;
        this.subTypeDes = subTypeDes;
    }

    protected SubPoiItem(Parcel in) {
        poiId = in.readString();
        title = in.readString();
        subName = in.readString();
        distance = in.readInt();
        point = in.readParcelable(LatLngPoint.class.getClassLoader());
        snippet = in.readString();
        subTypeDes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poiId);
        dest.writeString(title);
        dest.writeString(subName);
        dest.writeInt(distance);
        dest.writeParcelable(point, flags);
        dest.writeString(snippet);
        dest.writeString(subTypeDes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SubPoiItem> CREATOR = new Creator<SubPoiItem>() {
        @Override
        public SubPoiItem createFromParcel(Parcel in) {
            return new SubPoiItem(in);
        }

        @Override
        public SubPoiItem[] newArray(int size) {
            return new SubPoiItem[size];
        }
    };

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LatLngPoint getPoint() {
        return point;
    }

    public void setPoint(LatLngPoint point) {
        this.point = point;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSubTypeDes() {
        return subTypeDes;
    }

    public void setSubTypeDes(String subTypeDes) {
        this.subTypeDes = subTypeDes;
    }
}
