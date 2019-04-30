package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class PoiItem implements Parcelable, Serializable, Cloneable {

    private String businessArea;

    private String adName;

    private String cityName;

    private String provinceName;

    private String typeDes;

    private String tel;

    private String adCode;

    private String poiId;

    private int distance;

    private String title;

    private String snippet;

    private LatLngPoint point;

    private String cityCode;

    private LatLngPoint enter;

    private LatLngPoint exit;

    private String website;

    private String postcode;

    private String email;

    private String direction;

    private boolean indoorMap;

    private String provinceCode;

    private String parkingType;

    private List<Photo> photos;

    private List<SubPoiItem> subPois;

    private PoiItemExtension poiExtension;

    private String typeCode;

    private String shopID;

    public PoiItem() {
    }

    public PoiItem(String businessArea, String adName, String cityName, String provinceName, String typeDes, String tel, String adCode, String poiId, int distance, String title, String snippet, LatLngPoint point, String cityCode, LatLngPoint enter, LatLngPoint exit, String website, String postcode, String email, String direction, boolean indoorMap, String provinceCode, String parkingType, List<Photo> photos, List<SubPoiItem> subPois, PoiItemExtension poiExtension, String typeCode, String shopID) {
        this.businessArea = businessArea;
        this.adName = adName;
        this.cityName = cityName;
        this.provinceName = provinceName;
        this.typeDes = typeDes;
        this.tel = tel;
        this.adCode = adCode;
        this.poiId = poiId;
        this.distance = distance;
        this.title = title;
        this.snippet = snippet;
        this.point = point;
        this.cityCode = cityCode;
        this.enter = enter;
        this.exit = exit;
        this.website = website;
        this.postcode = postcode;
        this.email = email;
        this.direction = direction;
        this.indoorMap = indoorMap;
        this.provinceCode = provinceCode;
        this.parkingType = parkingType;
        this.photos = photos;
        this.subPois = subPois;
        this.poiExtension = poiExtension;
        this.typeCode = typeCode;
        this.shopID = shopID;
    }

    protected PoiItem(Parcel in) {
        businessArea = in.readString();
        adName = in.readString();
        cityName = in.readString();
        provinceName = in.readString();
        typeDes = in.readString();
        tel = in.readString();
        adCode = in.readString();
        poiId = in.readString();
        distance = in.readInt();
        title = in.readString();
        snippet = in.readString();
        point = in.readParcelable(LatLngPoint.class.getClassLoader());
        cityCode = in.readString();
        enter = in.readParcelable(LatLngPoint.class.getClassLoader());
        exit = in.readParcelable(LatLngPoint.class.getClassLoader());
        website = in.readString();
        postcode = in.readString();
        email = in.readString();
        direction = in.readString();
        indoorMap = in.readByte() != 0;
        provinceCode = in.readString();
        parkingType = in.readString();
        photos = in.createTypedArrayList(Photo.CREATOR);
        subPois = in.createTypedArrayList(SubPoiItem.CREATOR);
        poiExtension = in.readParcelable(PoiItemExtension.class.getClassLoader());
        typeCode = in.readString();
        shopID = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(businessArea);
        dest.writeString(adName);
        dest.writeString(cityName);
        dest.writeString(provinceName);
        dest.writeString(typeDes);
        dest.writeString(tel);
        dest.writeString(adCode);
        dest.writeString(poiId);
        dest.writeInt(distance);
        dest.writeString(title);
        dest.writeString(snippet);
        dest.writeParcelable(point, flags);
        dest.writeString(cityCode);
        dest.writeParcelable(enter, flags);
        dest.writeParcelable(exit, flags);
        dest.writeString(website);
        dest.writeString(postcode);
        dest.writeString(email);
        dest.writeString(direction);
        dest.writeByte((byte) (indoorMap ? 1 : 0));
        dest.writeString(provinceCode);
        dest.writeString(parkingType);
        dest.writeTypedList(photos);
        dest.writeTypedList(subPois);
        dest.writeParcelable(poiExtension, flags);
        dest.writeString(typeCode);
        dest.writeString(shopID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PoiItem> CREATOR = new Creator<PoiItem>() {
        @Override
        public PoiItem createFromParcel(Parcel in) {
            return new PoiItem(in);
        }

        @Override
        public PoiItem[] newArray(int size) {
            return new PoiItem[size];
        }
    };

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getTypeDes() {
        return typeDes;
    }

    public void setTypeDes(String typeDes) {
        this.typeDes = typeDes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public LatLngPoint getPoint() {
        return point;
    }

    public void setPoint(LatLngPoint point) {
        this.point = point;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public LatLngPoint getEnter() {
        return enter;
    }

    public void setEnter(LatLngPoint enter) {
        this.enter = enter;
    }

    public LatLngPoint getExit() {
        return exit;
    }

    public void setExit(LatLngPoint exit) {
        this.exit = exit;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isIndoorMap() {
        return indoorMap;
    }

    public void setIndoorMap(boolean indoorMap) {
        this.indoorMap = indoorMap;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<SubPoiItem> getSubPois() {
        return subPois;
    }

    public void setSubPois(List<SubPoiItem> subPois) {
        this.subPois = subPois;
    }

    public PoiItemExtension getPoiExtension() {
        return poiExtension;
    }

    public void setPoiExtension(PoiItemExtension poiExtension) {
        this.poiExtension = poiExtension;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }
}
