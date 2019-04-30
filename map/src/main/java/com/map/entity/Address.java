package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Address implements Parcelable, Serializable, Cloneable {

    private String formatAddress;

    private String province;

    private String city;

    private String cityCode;

    private String adCode;

    private String district;

    private String township; //乡

    private String neighborhood; //邻里

    private String building;  //楼宇

    private String towncode;

    private String country;

    private LatLngPoint point;

    public Address() {
    }

    public Address(String formatAddress, String province, String city, String cityCode, String adCode, String district, String township, String neighborhood, String building, String towncode, String country, LatLngPoint point) {
        this.formatAddress = formatAddress;
        this.province = province;
        this.city = city;
        this.cityCode = cityCode;
        this.adCode = adCode;
        this.district = district;
        this.township = township;
        this.neighborhood = neighborhood;
        this.building = building;
        this.towncode = towncode;
        this.country = country;
        this.point = point;
    }

    protected Address(Parcel in) {
        formatAddress = in.readString();
        province = in.readString();
        city = in.readString();
        cityCode = in.readString();
        adCode = in.readString();
        district = in.readString();
        township = in.readString();
        neighborhood = in.readString();
        building = in.readString();
        towncode = in.readString();
        country = in.readString();
        point = in.readParcelable(LatLngPoint.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(formatAddress);
        dest.writeString(province);
        dest.writeString(city);
        dest.writeString(cityCode);
        dest.writeString(adCode);
        dest.writeString(district);
        dest.writeString(township);
        dest.writeString(neighborhood);
        dest.writeString(building);
        dest.writeString(towncode);
        dest.writeString(country);
        dest.writeParcelable(point, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    public String getFormatAddress() {
        return formatAddress;
    }

    public void setFormatAddress(String formatAddress) {
        this.formatAddress = formatAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getTowncode() {
        return towncode;
    }

    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LatLngPoint getPoint() {
        return point;
    }

    public void setPoint(LatLngPoint point) {
        this.point = point;
    }
}
