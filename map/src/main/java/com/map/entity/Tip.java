package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Tip implements Parcelable, Serializable, Cloneable {

    private String poiID;
    private LatLngPoint point;
    private String name;
    private String district;
    private String adcode;
    private String address;
    private String typeCode;

    public Tip() {
    }

    public Tip(String poiID, LatLngPoint point, String name, String district, String adcode, String address, String typeCode) {
        this.poiID = poiID;
        this.point = point;
        this.name = name;
        this.district = district;
        this.adcode = adcode;
        this.address = address;
        this.typeCode = typeCode;
    }

    protected Tip(Parcel in) {
        poiID = in.readString();
        point = in.readParcelable(LatLngPoint.class.getClassLoader());
        name = in.readString();
        district = in.readString();
        adcode = in.readString();
        address = in.readString();
        typeCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poiID);
        dest.writeParcelable(point, flags);
        dest.writeString(name);
        dest.writeString(district);
        dest.writeString(adcode);
        dest.writeString(address);
        dest.writeString(typeCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tip> CREATOR = new Creator<Tip>() {
        @Override
        public Tip createFromParcel(Parcel in) {
            return new Tip(in);
        }

        @Override
        public Tip[] newArray(int size) {
            return new Tip[size];
        }
    };

    public String getPoiID() {
        return poiID;
    }

    public void setPoiID(String poiID) {
        this.poiID = poiID;
    }

    public LatLngPoint getPoint() {
        return point;
    }

    public void setPoint(LatLngPoint point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
