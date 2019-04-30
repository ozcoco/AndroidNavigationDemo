package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Photo implements Parcelable, Serializable, Cloneable {

    private String title;

    private String url;

    public Photo() {
    }

    public Photo(String title, String url) {
        this.title = title;
        this.url = url;
    }

    protected Photo(Parcel in) {
        title = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
