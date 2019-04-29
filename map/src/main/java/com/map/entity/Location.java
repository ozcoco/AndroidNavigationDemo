package com.map.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Location implements Parcelable, Serializable, Cloneable {

    private long time = 0;

    private long elapsedRealtimeNanos = 0;

    private double latitude = 0.0;

    private double longitude = 0.0;

    private double altitude = 0.0f;

    private float speed = 0.0f;

    private float bearing = 0.0f;

    private float horizontalAccuracyMeters = 0.0f;

    private float verticalAccuracyMeters = 0.0f;

    private float speedAccuracyMetersPerSecond = 0.0f;

    private float bearingAccuracyDegrees = 0.0f;


    public Location() {
    }

    public Location(long time, long elapsedRealtimeNanos, double latitude, double longitude, double altitude, float speed, float bearing, float horizontalAccuracyMeters, float verticalAccuracyMeters, float speedAccuracyMetersPerSecond, float bearingAccuracyDegrees) {
        this.time = time;
        this.elapsedRealtimeNanos = elapsedRealtimeNanos;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
        this.bearing = bearing;
        this.horizontalAccuracyMeters = horizontalAccuracyMeters;
        this.verticalAccuracyMeters = verticalAccuracyMeters;
        this.speedAccuracyMetersPerSecond = speedAccuracyMetersPerSecond;
        this.bearingAccuracyDegrees = bearingAccuracyDegrees;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getElapsedRealtimeNanos() {
        return elapsedRealtimeNanos;
    }

    public void setElapsedRealtimeNanos(long elapsedRealtimeNanos) {
        this.elapsedRealtimeNanos = elapsedRealtimeNanos;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public float getHorizontalAccuracyMeters() {
        return horizontalAccuracyMeters;
    }

    public void setHorizontalAccuracyMeters(float horizontalAccuracyMeters) {
        this.horizontalAccuracyMeters = horizontalAccuracyMeters;
    }

    public float getVerticalAccuracyMeters() {
        return verticalAccuracyMeters;
    }

    public void setVerticalAccuracyMeters(float verticalAccuracyMeters) {
        this.verticalAccuracyMeters = verticalAccuracyMeters;
    }

    public float getSpeedAccuracyMetersPerSecond() {
        return speedAccuracyMetersPerSecond;
    }

    public void setSpeedAccuracyMetersPerSecond(float speedAccuracyMetersPerSecond) {
        this.speedAccuracyMetersPerSecond = speedAccuracyMetersPerSecond;
    }

    public float getBearingAccuracyDegrees() {
        return bearingAccuracyDegrees;
    }

    public void setBearingAccuracyDegrees(float bearingAccuracyDegrees) {
        this.bearingAccuracyDegrees = bearingAccuracyDegrees;
    }


    @Override
    public String toString() {
        return "Location{" +
                "time=" + time +
                ", elapsedRealtimeNanos=" + elapsedRealtimeNanos +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", bearing=" + bearing +
                ", horizontalAccuracyMeters=" + horizontalAccuracyMeters +
                ", verticalAccuracyMeters=" + verticalAccuracyMeters +
                ", speedAccuracyMetersPerSecond=" + speedAccuracyMetersPerSecond +
                ", bearingAccuracyDegrees=" + bearingAccuracyDegrees +
                '}';
    }

    protected Location(Parcel in) {
        time = in.readLong();
        elapsedRealtimeNanos = in.readLong();
        latitude = in.readDouble();
        longitude = in.readDouble();
        altitude = in.readDouble();
        speed = in.readFloat();
        bearing = in.readFloat();
        horizontalAccuracyMeters = in.readFloat();
        verticalAccuracyMeters = in.readFloat();
        speedAccuracyMetersPerSecond = in.readFloat();
        bearingAccuracyDegrees = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time);
        dest.writeLong(elapsedRealtimeNanos);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeDouble(altitude);
        dest.writeFloat(speed);
        dest.writeFloat(bearing);
        dest.writeFloat(horizontalAccuracyMeters);
        dest.writeFloat(verticalAccuracyMeters);
        dest.writeFloat(speedAccuracyMetersPerSecond);
        dest.writeFloat(bearingAccuracyDegrees);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
