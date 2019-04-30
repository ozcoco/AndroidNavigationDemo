package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PoiItemExtension implements Parcelable, Serializable, Cloneable {

    private String opentime;

    private String rating;

    public PoiItemExtension() {
    }

    public PoiItemExtension(String opentime, String rating) {
        this.opentime = opentime;
        this.rating = rating;
    }

    protected PoiItemExtension(Parcel in) {
        opentime = in.readString();
        rating = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(opentime);
        dest.writeString(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PoiItemExtension> CREATOR = new Creator<PoiItemExtension>() {
        @Override
        public PoiItemExtension createFromParcel(Parcel in) {
            return new PoiItemExtension(in);
        }

        @Override
        public PoiItemExtension[] newArray(int size) {
            return new PoiItemExtension[size];
        }
    };

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
